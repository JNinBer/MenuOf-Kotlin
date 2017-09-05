package cn.jninber.client.menu.presenter

import cn.jninber.client.menu.contract.CategoryContract
import cn.jninber.client.model.CategoryObject
import com.vicpin.krealmextensions.delete
import com.vicpin.krealmextensions.queryAllAsObservable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by jninber on 2017/8/30.
 *
 **/
class CategoryPresenter(var view: CategoryContract.View) : CategoryContract.Presenter {


    init {
        view.setPresenter(this)
        start()
    }

    override fun start() {
        qureyCategory(false)
    }

    override fun qureyCategory(isClear: Boolean) {
        CategoryObject().queryAllAsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { collection ->
            collection.sortedBy { it.type }
            view.onChange(collection)
        }
    }

    override fun deleteMenu(id: String) {

        val categoryObject1 = CategoryObject()
        categoryObject1.delete { it.equalTo("id", id) }

    }

}