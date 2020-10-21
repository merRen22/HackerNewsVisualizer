package com.hacker.hackernewsvisualizer.di

import androidx.lifecycle.ViewModel
import com.hacker.hackernewsvisualizer.ui.MainActivity
import com.hacker.hackernewsvisualizer.viewmodel.PublicationsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Builder for activity.
 * [MainActivity] is the only activity of this app, since this is single-activity application.
 * Single Activity was chosen because Navigation from Jet Pack recommends it
 */
@Module
interface  ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class,
            FragmentBuilder::class
        ]
    )
    fun contributeMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(PublicationsViewModel::class)
    fun bindPublicationsViewModel(viewModel: PublicationsViewModel): ViewModel
}