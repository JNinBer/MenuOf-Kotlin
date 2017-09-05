package cn.jninber.client.edit.contract

import android.content.Context
import com.netease.enjoy.self.base.mvp.BasePresenter
import com.netease.enjoy.self.base.mvp.BaseView

/**
 * Created by jninber on 2017/9/1.
 *
 **/
interface EditContract {

    interface View : BaseView<Presenter> {

        fun getCategoryName(): String

        fun pageDestroy()

    }

    interface Presenter : BasePresenter {

        fun saveCategory()


        fun startEditMenuPage(context: Context)
    }
}