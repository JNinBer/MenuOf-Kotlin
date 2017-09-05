package cn.jninber.client.edit

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import cn.jninber.client.R
import cn.jninber.client.base.BaseActivity
import cn.jninber.client.edit.component.DaggerEditCategoryComponent
import cn.jninber.client.edit.contract.EditContract
import cn.jninber.client.edit.module.EditCategoryModule
import cn.jninber.client.edit.presenter.EditCategoryPresenter
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_edit_menu.*
import javax.inject.Inject

@Suppress("UNUSED_EXPRESSION")
class EditCategoryActivity : BaseActivity(), EditContract.View {
    override fun pageDestroy() {
        onBackPressed()
    }

    override fun getDisposable(): CompositeDisposable {
        return compositeDisposable
    }

    override fun getCategoryName(): String {
        return editMenuName.text.toString()
    }

    @Inject lateinit var presenter: EditCategoryPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_menu)
        setSupportActionBar(toolbar)
        DaggerEditCategoryComponent.builder().editCategoryModule(EditCategoryModule(this)).build().inject(this)
        toolbar.setNavigationOnClickListener { finish() }

        editSubmit.setOnClickListener {
            presenter.saveCategory()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.edit -> {
                presenter.startEditMenuPage(this)
                true
            }
        }
        return false

    }

}
