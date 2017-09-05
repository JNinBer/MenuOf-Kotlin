package cn.jninber.client.menu

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.jninber.client.R
import cn.jninber.client.common.dip
import cn.jninber.client.base.BaseFragment
import cn.jninber.client.menu.component.DaggerCategoryFragmentComponent
import cn.jninber.client.menu.contract.CategoryContract
import cn.jninber.client.menu.module.CategoryFragmentModule
import cn.jninber.client.menu.presenter.CategoryPresenter
import cn.jninber.client.model.CategoryObject
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_category.*
import javax.inject.Inject


/**
 * Created by jninber on 2017/7/14.
 *
 **/
class CategoryFragment : BaseFragment(), CategoryContract.View {
    override fun showDeleteDialog(item: CategoryObject) {
        AlertDialog.Builder(activity).setTitle("删除菜单").setMessage("正在删除${item.name}").setPositiveButton("删除", { dialog, _ ->
            dialog.dismiss()
            categoryPresenter.deleteMenu(item.id)
        }).create().show()
    }

    override fun getDisposable(): CompositeDisposable {
        return compositeDisposable
    }

    override fun onChange(data: Collection<CategoryObject>) {
        adapter.replaceData(data)
    }

    @Inject lateinit var adapter: CategoryAdapter
    @Inject lateinit var categoryPresenter: CategoryPresenter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerCategoryFragmentComponent.builder().categoryFragmentModule(CategoryFragmentModule(this)).build().inject(this)

        categoryPresenter.start()
        categoryRecycler.adapter = adapter
        swipeRefreshLayout.isEnabled = false
        categoryRecycler.layoutManager = LinearLayoutManager(this.activity)
        categoryRecycler.addItemDecoration(HorizontalDividerItemDecoration.Builder(activity)
                .size(activity.dip(10))
                .color(ContextCompat.getColor(activity, android.R.color.transparent)).build())
        adapter.setOnItemChildClickListener { _adapter, _view, position ->
            val intent = Intent(activity, CategoryActivity::class.java)
            intent.putExtra(SubCategoryFragment.INTENT_EXTR, this.adapter.getItem(position)?.id)
            startActivity(intent)
        }


        adapter.setOnItemLongClickListener { _adapter, _view, position ->
            showDeleteDialog(adapter.getItem(position)!!)
            return@setOnItemLongClickListener true
        }
    }

}