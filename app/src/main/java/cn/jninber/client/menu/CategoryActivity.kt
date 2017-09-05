package cn.jninber.client.menu

import android.os.Bundle
import cn.jninber.client.R

import cn.jninber.client.base.BaseActivity
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : BaseActivity(), SubCategoryFragment.OnBindTitleListener {
    override fun onBindTitle(title: String) {
        toolbar.title = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setSupportActionBar(toolbar)
        val mId = intent.getStringExtra(SubCategoryFragment.INTENT_EXTR)
        supportFragmentManager.beginTransaction().replace(R.id.contentFragment, SubCategoryFragment.getNewInstans(mId)).commitAllowingStateLoss()

    }
}
