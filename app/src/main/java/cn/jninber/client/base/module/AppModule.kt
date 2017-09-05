package cn.jninber.client.base.module

import cn.jninber.client.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jninber on 2017/7/6.
 *
 **/
@Module
class AppModule(val app: App) {
    @Provides @Singleton fun provideApplication() = app
}