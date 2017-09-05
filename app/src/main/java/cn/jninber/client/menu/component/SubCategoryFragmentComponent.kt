package cn.jninber.client.menu.component

import cn.jninber.client.menu.SubCategoryFragment
import cn.jninber.client.menu.module.SubCategoryFragmentModule
import dagger.Component

/**
 * Created by jninber on 2017/8/31.
 *
 **/
@Component(modules = arrayOf(SubCategoryFragmentModule::class))
interface SubCategoryFragmentComponent {
    fun inject(sub: SubCategoryFragment)
}