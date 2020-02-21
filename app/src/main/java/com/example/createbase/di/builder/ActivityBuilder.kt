package com.example.createbase.di.builder

import com.example.createbase.di.login.LoginModule
import com.example.createbase.di.login.LoginViewModelsModule
import com.example.createbase.di.splash.SplashModule
import com.example.createbase.di.splash.SplashViewModelsModule
import com.example.createbase.ui.login.LoginActivity
import com.example.createbase.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashViewModelsModule::class, SplashModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginViewModelsModule::class, LoginModule::class])
    abstract fun bindLoginActivity(): LoginActivity
}
