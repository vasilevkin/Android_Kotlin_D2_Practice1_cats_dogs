package com.vasilevkin.catsanddogs

import android.app.Application
import com.facebook.stetho.Stetho

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Start Koin
//        startKoin(this, listOf(appDiModule))

        // Create an InitializerBuilder
        val initializerBuilder = Stetho.newInitializerBuilder(this)

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
            Stetho.defaultInspectorModulesProvider(this)
        )

        // Enable command line interface
        initializerBuilder.enableDumpapp(
            Stetho.defaultDumperPluginsProvider(this)
        )

        // Use the InitializerBuilder to generate an Initializer
        val initializer = initializerBuilder.build()

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer)
    }
}