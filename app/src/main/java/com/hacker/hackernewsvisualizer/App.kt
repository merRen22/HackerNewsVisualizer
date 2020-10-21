package com.hacker.hackernewsvisualizer

import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.hacker.hackernewsvisualizer.di.DaggerAppComponent

/**
 * Application class. [DaggerApplication] injects classes behind scene.
 * This allows for the injection of parameters in all constructors across the app
 */
open class App : DaggerApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}