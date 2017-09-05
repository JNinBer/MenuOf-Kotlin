package cn.jninber.client.menu

import cn.jninber.client.R
import cn.jninber.client.model.DetailObject
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by jninber on 2017/8/30.
 *
 **/
class SubCategoryAdapter : BaseQuickAdapter<DetailObject, BaseViewHolder>(R.layout.recycler_item_category) {
    override fun convert(helper: BaseViewHolder?, item: DetailObject?) {
        helper?.setText(R.id.itemName, item?.name)?.addOnClickListener(R.id.itemName)?.addOnLongClickListener(R.id.itemName)

    }
}