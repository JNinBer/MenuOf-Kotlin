package cn.jninber.client.menu.contract

import cn.jninber.client.model.DetailObject
import com.netease.enjoy.self.base.mvp.BasePresenter
import com.netease.enjoy.self.base.mvp.BaseView

/**
 * Created by jninber on 2017/8/31.
 *
 **/
interface SubCategoryContract {

    interface View : BaseView<Presenter> {
        fun doBindData(collection: Collection<DetailObject>)

        fun doChangeTitle(title: String)
    }

    interface Presenter : BasePresenter {
        fun qurey(id: String)
    }
}