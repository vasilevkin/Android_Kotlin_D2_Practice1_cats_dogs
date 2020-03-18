package com.vasilevkin.catsanddogs.features.splash.presenter

import com.vasilevkin.catsanddogs.base.BasePresenter
import com.vasilevkin.catsanddogs.features.splash.ISplashContract


class SplashPresenter : BasePresenter<ISplashContract.View>(), ISplashContract.Presenter {

    override fun onViewCreated() {
        view?.finishView()
    }

    override fun onViewDestroyed() {
        view = null
    }
}
