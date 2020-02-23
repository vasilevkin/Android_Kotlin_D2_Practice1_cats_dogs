package com.vasilevkin.catsanddogs.features.splash

interface ISplashContract {

    interface Presenter {
        // View updates
        fun onViewCreated()

        fun onViewDestroyed()
    }

    interface View {
        fun finishView()
    }
}
