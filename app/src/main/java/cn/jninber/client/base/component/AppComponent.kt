package cn.jninber.client.base.component

import cn.jninber.client.App
import cn.jninber.client.base.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jninber on 2017/7/6.
 *
 **/

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
}