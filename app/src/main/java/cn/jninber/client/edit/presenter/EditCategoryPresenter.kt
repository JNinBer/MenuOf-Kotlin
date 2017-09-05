package cn.jninber.client.edit.presenter

import android.content.Context
import android.content.Intent
import cn.jninber.client.edit.EditMenuDetailActivity
import cn.jninber.client.edit.contract.EditContract
import cn.jninber.client.model.CategoryObject
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_edit_menu.*
import java.util.*

/**
 * Created by jninber on 2017/9/1.
 *
 **/
class EditCategoryPresenter(var view: EditContract.View) : EditContract.Presenter {
    override fun startEditMenuPage(context: Context) {
        context.startActivity(Intent(context, EditMenuDetailActivity::class.java))
    }

    init {
        view.setPresenter(this)
    }

    override fun start() {

    }

    override fun saveCategory() {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val cate = realm.createObject(CategoryObject::class.java, UUID.randomUUID().toString())
        cate.type = System.currentTimeMillis()
        cate.name = view.getCategoryName()
        realm.commitTransaction()
        realm.close()
        view.pageDestroy()
    }
}