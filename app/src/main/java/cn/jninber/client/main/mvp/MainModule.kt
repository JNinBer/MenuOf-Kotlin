package cn.jninber.client.main.mvp

import dagger.Module
import dagger.Provides

/**
 * Created by jninber on 2017/8/30.
 *
 **/

@Module
class MainModule(var main: MainContract.View) {
    @Provides
    fun providePresenter(): MainPresenter {
        return MainPresenter(main)
    }

}