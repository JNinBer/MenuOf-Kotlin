package cn.jninber.client.menu.module

import cn.jninber.client.menu.SubCategoryAdapter
import cn.jninber.client.menu.contract.SubCategoryContract
import cn.jninber.client.menu.presenter.SubCatgoryPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by jninber on 2017/8/31.
 *
 **/
@Module
class SubCategoryFragmentModule(var view: SubCategoryContract.View) {

    @Provides fun providesAdapter(): SubCategoryAdapter {
        return SubCategoryAdapter()
    }

    @Provides fun providesPresenter(): SubCatgoryPresenter {
        return SubCatgoryPresenter(view)
    }


}