package com.vasilevkin.catsanddogs.splash

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
