package cn.jninber.client

import android.app.Activity
import android.app.Application
import android.os.Bundle
import cn.jninber.client.base.BaseActivity
import cn.jninber.client.main.MainActivity
import java.util.*

/**
 * DutyWork
 * Created by Malei on 2016/10/18.
 */

class ActivityLifecycle : Application.ActivityLifecycleCallbacks {

    private val mActivities = ArrayList<Activity>()

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        mActivities.add(0, activity)

    }

    override fun onActivityStarted(activity: Activity) {
        if (activity is BaseActivity) {
            when (activity) {
                is MainActivity -> {
                    activity.supportActionBar?.setDisplayShowTitleEnabled(true)
                    activity.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_account_circle_black_24dp)
                }
            }
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }

    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        mActivities.remove(activity)

    }

    fun finishAllActivity() {
        for (vActivity in mActivities) {
            vActivity.finish()
        }
        mActivities.clear()
    }
}
