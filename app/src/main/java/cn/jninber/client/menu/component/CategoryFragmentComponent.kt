package cn.jninber.client.menu.component

import cn.jninber.client.menu.CategoryFragment
import cn.jninber.client.menu.module.CategoryFragmentModule
import dagger.Component

/**
 * Created by jninber on 2017/8/30.
 *
 **/

@Component(modules = arrayOf(CategoryFragmentModule::class))
interface CategoryFragmentComponent {
    fun inject(fragment: CategoryFragment)
}