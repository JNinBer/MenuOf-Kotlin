package cn.jninber.client.main.mvp

import com.netease.enjoy.self.base.mvp.BasePresenter
import com.netease.enjoy.self.base.mvp.BaseView

/**
 * Created by jninber on 2017/8/30.
 *
 **/
interface MainContract {

    interface View : BaseView<MainPresenter> {

        fun bindBottomBar()
        fun bindInitFragment()

        fun bindDefaultFragment()

        fun onBottomBarItemSelect(position: Int)

        fun onBottomBarItemUnSelect(position: Int)

        fun onStartEditMenuPage()
    }

    interface MainPresenter : BasePresenter {


        fun onBindBottomBarSelect(position: Int)

        fun onBindBottomBarUnSelect(position: Int)


        fun onStartEditPage()
    }
}