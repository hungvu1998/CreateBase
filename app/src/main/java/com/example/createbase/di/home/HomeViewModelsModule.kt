package com.example.createbase.di.home

import androidx.lifecycle.ViewModel
import com.example.createbase.di.ViewModelKey
import com.example.createbase.ui.home.HomeViewModel
import com.example.createbase.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}