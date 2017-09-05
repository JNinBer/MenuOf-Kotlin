package cn.jninber.client.menu.presenter

import cn.jninber.client.menu.contract.SubCategoryContract
import cn.jninber.client.model.CategoryObject
import io.realm.Realm

/**
 * Created by jninber on 2017/8/31.
 *
 **/
class SubCatgoryPresenter(var view: SubCategoryContract.View) : SubCategoryContract.Presenter {

    init {
        view.setPresenter(this)
        start()
    }

    override fun start() {

    }

    override fun qurey(id: String) {
        val categoryObject = Realm.getDefaultInstance().where(CategoryObject::class.java).equalTo("id", id).findFirstAsync()
        categoryObject.addChangeListener<CategoryObject> { item ->
            view.doChangeTitle(item.name)
            view.doBindData(item.menu ?: mutableListOf())
        }
    }
}