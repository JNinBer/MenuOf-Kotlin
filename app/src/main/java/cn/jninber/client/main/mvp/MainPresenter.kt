package cn.jninber.client.main.mvp

/**
 * Created by jninber on 2017/8/30.
 *
 **/
class MainPresenter(var mainView: MainContract.View) : MainContract.MainPresenter {

    init {
        mainView.setPresenter(this)
    }

    override fun start() {
        mainView.bindInitFragment()
        mainView.bindBottomBar()
        mainView.bindDefaultFragment()
    }


    override fun onBindBottomBarSelect(position: Int) {
        mainView.onBottomBarItemSelect(position)
    }

    override fun onBindBottomBarUnSelect(position: Int) {
        mainView.onBottomBarItemUnSelect(position)
    }

    override fun onStartEditPage() {
        mainView.onStartEditMenuPage()
    }

}