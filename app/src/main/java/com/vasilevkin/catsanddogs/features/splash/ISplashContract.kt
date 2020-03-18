package com.vasilevkin.catsanddogs.features.splash

import com.vasilevkin.catsanddogs.base.BaseContract

interface ISplashContract {

    interface Presenter : BaseContract.Presenter {
        fun onViewDestroyed()
    }

    interface View : BaseContract.View {
        fun finishView()
    }
}
