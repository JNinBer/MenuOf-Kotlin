package cn.jninber.client.menu

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.jninber.client.R
import cn.jninber.client.base.BaseFragment
import cn.jninber.client.menu.component.DaggerSubCategoryFragmentComponent
import cn.jninber.client.menu.contract.SubCategoryContract
import cn.jninber.client.menu.module.SubCategoryFragmentModule
import cn.jninber.client.menu.presenter.SubCatgoryPresenter
import cn.jninber.client.model.DetailObject
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_category.*
import javax.inject.Inject

/**
 * Created by jninber on 2017/8/11.
 *
 **/

class SubCategoryFragment : BaseFragment, SubCategoryContract.View {
    override fun getDisposable(): CompositeDisposable {
        return compositeDisposable
    }

    override fun doBindData(collection: Collection<DetailObject>) {
        adapter.replaceData(collection)
    }

    override fun doChangeTitle(title: String) {
        onBindTitle.onBindTitle(title)
    }


    constructor()

    companion object {

        const val INTENT_EXTR = "EXTR_ID"
        fun getNewInstans(id: String): SubCategoryFragment {
            val subCategoryFragment = SubCategoryFragment()
            val bundle = Bundle()
            bundle.putString(INTENT_EXTR, id)
            subCategoryFragment.arguments = bundle
            return subCategoryFragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_category, container, false)
    }


    lateinit var onBindTitle: OnBindTitleListener


    @Inject lateinit var adapter: SubCategoryAdapter

    @Inject lateinit var subPresenter: SubCatgoryPresenter
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var categoryId = arguments?.getString(INTENT_EXTR)
        DaggerSubCategoryFragmentComponent.builder().subCategoryFragmentModule(SubCategoryFragmentModule(this)).build().inject(this)
        swipeRefreshLayout.isEnabled = false
        categoryRecycler.layoutManager = LinearLayoutManager(this.activity)
        categoryRecycler.adapter = adapter

        subPresenter.qurey(categoryId!!)


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnBindTitleListener) {
            onBindTitle = context
        } else throw  RuntimeException("OnBindTitleListener is Null")
    }


    interface OnBindTitleListener {
        fun onBindTitle(title: String)
    }
}