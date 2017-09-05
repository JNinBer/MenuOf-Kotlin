package cn.jninber.client.menu.contract

import cn.jninber.client.model.CategoryObject
import com.netease.enjoy.self.base.mvp.BasePresenter
import com.netease.enjoy.self.base.mvp.BaseView

/**
 * Created by jninber on 2017/8/30.
 *
 **/
interface CategoryContract {


    interface View : BaseView<Presenter> {

        fun onChange(data: Collection<CategoryObject>)


        fun showDeleteDialog(item: CategoryObject)
    }

    interface Presenter : BasePresenter {

        fun qureyCategory(isClear: Boolean)

        fun deleteMenu(id: String)
    }
}