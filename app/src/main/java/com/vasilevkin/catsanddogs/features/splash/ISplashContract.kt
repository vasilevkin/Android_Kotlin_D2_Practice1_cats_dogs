package com.vasilevkin.catsanddogs.features.splash

interface ISplashContract {

    interface Presenter {
        fun onViewCreated()
        fun onViewDestroyed()
    }

    interface View {
        fun finishView()
    }
}
