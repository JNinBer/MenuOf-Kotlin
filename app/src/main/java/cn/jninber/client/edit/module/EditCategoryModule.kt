package cn.jninber.client.edit.module

import cn.jninber.client.edit.contract.EditContract
import cn.jninber.client.edit.presenter.EditCategoryPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by jninber on 2017/9/1.
 *
 **/
@Module
class EditCategoryModule(var view: EditContract.View) {
    @Provides fun providesPresenter() = EditCategoryPresenter(view)
}