package cn.jninber.client.edit.component

import cn.jninber.client.edit.EditCategoryActivity
import cn.jninber.client.edit.module.EditCategoryModule
import dagger.Component

/**
 * Created by jninber on 2017/9/1.
 *
 **/
@Component(modules = arrayOf(EditCategoryModule::class))
interface EditCategoryComponent {
    fun inject(activity: EditCategoryActivity)
}