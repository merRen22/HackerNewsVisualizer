package com.hacker.hackernewsvisualizer.di

import android.app.Application
import com.hacker.hackernewsvisualizer.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * The main component of the app.
 * Add all application scoped modules.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,

        ViewModelFactoryModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)
}