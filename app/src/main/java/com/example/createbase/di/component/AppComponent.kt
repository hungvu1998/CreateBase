package com.example.createbase.di.component

import android.app.Application
import com.example.createbase.MvvmApp
import com.example.createbase.ViewModelProviderFactory
import com.example.createbase.di.ViewModelFactoryModule
import com.example.createbase.di.builder.ActivityBuilder
import com.example.createbase.di.module.AppModule
import dagger.BindsInstance
import javax.inject.Singleton
import dagger.Component
import dagger.android.AndroidInjectionModule

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class, ViewModelFactoryModule::class])
interface AppComponent {

    fun inject(app: MvvmApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
