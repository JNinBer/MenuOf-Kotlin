package cn.jninber.client.base

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by jninber on 2017/7/6.
 *
 **/
open class BaseActivity : AppCompatActivity() {

    var compositeDisposable = CompositeDisposable()


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (android.R.id.home == item?.itemId) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}