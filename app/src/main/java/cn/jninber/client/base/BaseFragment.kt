package cn.jninber.client.base

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by jninber on 2017/8/30.
 *
 **/
open class BaseFragment : Fragment() {
    var compositeDisposable = CompositeDisposable()
}