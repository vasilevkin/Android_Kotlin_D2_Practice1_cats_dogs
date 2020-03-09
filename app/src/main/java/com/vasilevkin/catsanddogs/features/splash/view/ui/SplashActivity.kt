package com.vasilevkin.catsanddogs.features.splash.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.vasilevkin.catsanddogs.R
import com.vasilevkin.catsanddogs.features.animalList.view.ui.MainActivity
import com.vasilevkin.catsanddogs.features.splash.ISplashContract
import io.reactivex.Completable
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.util.concurrent.TimeUnit


/**
 * Splash Screen with the app icon and name at the center, this is also the launch screen and
 * opens up in fullscreen mode. Once launched it waits for 2 seconds after which it opens the
 * MainActivity
 */
class SplashActivity : AppCompatActivity(), ISplashContract.View {

    private val splashPresenter: ISplashContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeFullScreen()

        setContentView(R.layout.activity_splash)

        Completable.complete()
            .delay(2, TimeUnit.SECONDS)
            .doOnComplete { startMainActivity() }
            .subscribe()
    }

    override fun finishView() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()

        splashPresenter.onViewDestroyed()
    }

    private fun makeFullScreen() {
        // Remove Title
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Make Fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Hide the toolbar
        supportActionBar?.hide()
    }

    private fun startMainActivity() {
        // Start activity
        startActivity(Intent(this, MainActivity::class.java))

        // Animate the loading of new activity
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        // Close this activity
        splashPresenter.onViewCreated()
    }
}
