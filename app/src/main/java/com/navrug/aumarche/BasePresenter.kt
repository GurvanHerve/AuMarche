package com.navrug.aumarche

abstract class BasePresenter<V : BaseView>(view: V) {

    private var isPause = true

    open fun resume() {
        isPause = false
    }

    open fun pause() {
        isPause = true
    }
}