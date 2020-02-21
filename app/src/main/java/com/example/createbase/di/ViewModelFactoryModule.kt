package com.example.createbase.di

import androidx.lifecycle.ViewModelProvider
import com.example.createbase.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory

}
//@Module
//abstract class ViewModelFactoryModule {
//    @Binds
//    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
//}