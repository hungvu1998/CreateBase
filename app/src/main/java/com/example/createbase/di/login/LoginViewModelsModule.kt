package com.example.createbase.di.login

import androidx.lifecycle.ViewModel
import com.example.createbase.di.ViewModelKey
import com.example.createbase.ui.login.LoginViewModel
import com.example.createbase.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}