package cn.jninber.client.menu

import android.os.Bundle

import cn.jninber.client.R
import cn.jninber.client.base.BaseActivity
import cn.jninber.client.model.CategoryObject
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        var category = intent.getStringExtra("DETA")

        var detail = Realm.getDefaultInstance().where(CategoryObject::class.java).equalTo("id", category).findFirstAsync()

        detail.addChangeListener<CategoryObject> { _, _ ->

            detailImage

        }


    }
}
