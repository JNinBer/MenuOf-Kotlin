package cn.jninber.client.menu.module

import cn.jninber.client.menu.CategoryAdapter
import cn.jninber.client.menu.contract.CategoryContract
import cn.jninber.client.menu.presenter.CategoryPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by jninber on 2017/8/30.
 *
 **/

@Module
class CategoryFragmentModule(var view: CategoryContract.View) {
    @Provides fun providesAdapter(): CategoryAdapter {
        return CategoryAdapter()
    }

    @Provides fun providesCategoryPresenter(): CategoryPresenter {
        return CategoryPresenter(view)
    }

}