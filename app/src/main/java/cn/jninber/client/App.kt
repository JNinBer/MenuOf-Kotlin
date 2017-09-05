package cn.jninber.client

import android.app.Application
import cn.jninber.client.base.component.AppComponent
import cn.jninber.client.base.component.DaggerAppComponent
import io.realm.Realm
import io.realm.RealmConfiguration


/**
 * Created by jninber on 2017/5/3.
 *
 **/
class App : Application() {
    lateinit var activityLifecycle: ActivityLifecycle
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        activityLifecycle=ActivityLifecycle()
        registerActivityLifecycleCallbacks(activityLifecycle)
        val config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().name("RealmFile.realm").build()
        Realm.setDefaultConfiguration(config)
        component.inject(this)
    }


    override fun onTerminate() {
        super.onTerminate()
        unregisterActivityLifecycleCallbacks(activityLifecycle)
        activityLifecycle.finishAllActivity()
    }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder().build()
    }



}