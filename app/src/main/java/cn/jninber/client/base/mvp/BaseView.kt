package com.netease.enjoy.self.base.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface BaseView<T> {

    fun setPresenter(presenter: T) {}

    fun getDisposable(): CompositeDisposable
    fun onSubscribe(d: Disposable?) {
        getDisposable().add(d!!)
    }

}