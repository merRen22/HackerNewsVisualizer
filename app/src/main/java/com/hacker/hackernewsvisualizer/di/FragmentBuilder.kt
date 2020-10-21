package com.hacker.hackernewsvisualizer.di

import com.hacker.hackernewsvisualizer.ui.PublicationDetailFragment
import com.hacker.hackernewsvisualizer.ui.PublicationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Builder for Fragment.
 * Add all fragments that is added as a direct child of Activity.
 */
@Module
interface FragmentBuilder {

    /**
     * Publications Screens
     */
    @ContributesAndroidInjector
    fun contributePublicationsFragment(): PublicationsFragment

    /**
     * Publications Detail
     */
    @ContributesAndroidInjector
    fun contributePublicationDetailFragment(): PublicationDetailFragment


}