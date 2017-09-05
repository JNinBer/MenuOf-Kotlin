package cn.jninber.client.main.mvp

import cn.jninber.client.main.MainActivity
import dagger.Component

/**
 * Created by jninber on 2017/8/30.
 *
 **/

@Component(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}