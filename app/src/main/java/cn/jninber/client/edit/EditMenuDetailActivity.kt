package cn.jninber.client.edit

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.BaseAdapter
import cn.jninber.client.R
import cn.jninber.client.common.dip
import cn.jninber.client.base.BaseActivity
import cn.jninber.client.model.CategoryObject
import cn.jninber.client.model.DetailObject
import cn.jninber.client.model.MaterialObject
import com.vicpin.krealmextensions.queryAll
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_edit_menu_detail.*
import kotlinx.android.synthetic.main.recycler_item_category.view.*
import java.util.*


class EditMenuDetailActivity : BaseActivity() {

    lateinit var category: CategoryObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_menu_detail)
        setSupportActionBar(toolbar)
        val adapter = Adapter(this, CategoryObject().queryAll())
        detailType.adapter = adapter
        detailType.dropDownVerticalOffset = this.dip(45)
        detailType.setSelection(0)
        category = adapter.getItem(0)
        detailType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                category = adapter.getItem(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun saveMenuDetail() {
        val realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            val materialObject = it.createObject(MaterialObject::class.java, UUID.randomUUID().toString())
            materialObject.name = materialName1.text.toString()
            materialObject.weight = materialCount1.text.toString().toDoubleOrNull()
            val materialObject2 = it.createObject(MaterialObject::class.java, UUID.randomUUID().toString())
            materialObject2.name = materialName1.text.toString()
            materialObject2.weight = materialCount1.text.toString().toDoubleOrNull()
            it.copyToRealmOrUpdate(materialObject)
            it.copyToRealmOrUpdate(materialObject2)

            val detailObject = it.createObject(DetailObject::class.java, UUID.randomUUID().toString())
            detailObject.name = editName.text.toString()
            detailObject.img = "http://img3.utuku.china.com/628x0/news/20170715/f1e79df8-a3b4-4602-87fc-2947265f6ef9.jpg"
            detailObject.introduction = editDes.text.toString()
            detailObject.procedure = editProcedure.text.toString()
            detailObject.mark = editMark.text.toString()
            detailObject.favorite = false
            detailObject.material?.add(materialObject)
            detailObject.material?.add(materialObject2)
            it.copyToRealmOrUpdate(detailObject)

            category.menu?.add(detailObject)
            it.copyToRealmOrUpdate(category)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_save, menu)
        return true
    }

    @Suppress("UNUSED_EXPRESSION")
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (R.id.save == item?.itemId) {
            saveMenuDetail()
            true
        }
        return false
    }


    class Adapter(var mContext: Context, var list: List<CategoryObject>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val _LayoutInflater = LayoutInflater.from(mContext)
            var convert = _LayoutInflater.inflate(R.layout.recycler_item_category, null)
            if (convert != null) {
                convert.itemName.text = getItem(position).name
            }
            return convert
        }

        override fun getItem(position: Int): CategoryObject {
            return list[position]
        }

        override fun getItemId(position: Int): Long {
            return list[position].type!!.toLong()
        }

        override fun getCount(): Int {
            return list.size
        }

    }
}
