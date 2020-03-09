package com.vasilevkin.catsanddogs

import android.app.Application
import com.facebook.stetho.Stetho
import com.vasilevkin.catsanddogs.di.animalListModule
import com.vasilevkin.catsanddogs.di.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(listOf(animalListModule, splashModule))
        }

        // Create an InitializerBuilder
        val initializerBuilder = Stetho.newInitializerBuilder(this).also {

            // Enable Chrome DevTools
            it.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
            )

            // Enable command line interface
            it.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(this)
            )
        }

        // Use the InitializerBuilder to generate an Initializer
        val initializer = initializerBuilder.build()

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer)
    }
}