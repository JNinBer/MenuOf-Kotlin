package cn.jninber.client.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import cn.jninber.client.R
import cn.jninber.client.base.BaseActivity
import cn.jninber.client.edit.EditCategoryActivity
import cn.jninber.client.main.mvp.DaggerMainComponent
import cn.jninber.client.main.mvp.MainContract
import cn.jninber.client.main.mvp.MainModule
import cn.jninber.client.main.mvp.MainPresenter
import cn.jninber.client.menu.CategoryFragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by jninber on 2017/8/30.
 *
 **/
class MainActivity : BaseActivity(), MainContract.View, BottomNavigationBar.OnTabSelectedListener {
    override fun onTabReselected(position: Int) {

    }

    override fun onTabUnselected(position: Int) {
        mainPresenter.onBindBottomBarUnSelect(position)
    }

    override fun onTabSelected(position: Int) {
        mainPresenter.onBindBottomBarSelect(position)
    }


    private var fragments: MutableList<Fragment>? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun getDisposable(): CompositeDisposable {
        return compositeDisposable
    }

    override fun bindBottomBar() {
        bottomNavigationBar.addItem(BottomNavigationItem(R.drawable.ic_list_24dp, "分类"))
        bottomNavigationBar.addItem(BottomNavigationItem(R.drawable.ic_search_24dp, "搜索"))
        bottomNavigationBar.addItem(BottomNavigationItem(R.drawable.ic_favorite_border_24dp, "收藏"))
        bottomNavigationBar.addItem(BottomNavigationItem(R.drawable.ic_help_24dp, "帮助"))
        bottomNavigationBar.initialise()
        bottomNavigationBar.setTabSelectedListener(this)
    }


    override fun bindInitFragment() {
        fragments = mutableListOf<Fragment>()
        fragments?.add(CategoryFragment())
        fragments?.add(SearchFragment())
        fragments?.add(FavoriteFragment())
        fragments?.add(AboutFragment())
    }

    override fun bindDefaultFragment() {
        onTabSelected(0)
    }

    override fun onBottomBarItemSelect(position: Int) {
        if (position < fragments!!.size) {
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            val fragment = fragments!![position]
            if (fragment.isAdded) {
                ft.show(fragment)
            } else {
                ft.add(R.id.content_fragment, fragment)
            }
            ft.commitAllowingStateLoss()
        }
    }

    override fun onBottomBarItemUnSelect(position: Int) {
        if (fragments != null) {
            if (position < fragments!!.size) {
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                val fragment = fragments!![position]
                ft.hide(fragment)
                ft.commitAllowingStateLoss()
            }
        }
    }

    override fun onStartEditMenuPage() {
        startActivity(Intent(this, EditCategoryActivity::class.java))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        DaggerMainComponent.builder().mainModule(MainModule(this)).build().inject(this)
        mainPresenter.start()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.edit) {
            mainPresenter.onStartEditPage()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}