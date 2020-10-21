package com.hacker.hackernewsvisualizer.di.screen

import androidx.lifecycle.ViewModel
import com.hacker.hackernewsvisualizer.di.ViewModelKey
import com.hacker.hackernewsvisualizer.viewmodel.PublicationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PublicationsBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(PublicationsViewModel::class)
    fun bindPublicationsViewModel(viewModel: PublicationsViewModel): ViewModel
}