package com.vasilevkin.catsanddogs.features.splash.presenter

import com.vasilevkin.catsanddogs.features.splash.ISplashContract


class SplashPresenter(private var view: ISplashContract.View?) : ISplashContract.Presenter {

    override fun onViewCreated() {
        view?.finishView()
    }

    override fun onViewDestroyed() {
        view = null
    }
}
