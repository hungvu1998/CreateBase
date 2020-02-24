package com.example.createbase

import android.app.Activity
import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.example.createbase.di.component.DaggerAppComponent
import com.example.createbase.utils.AppLogger
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

class MvvmApp : Application(), HasActivityInjector {



    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    //@Inject
   // internal var mCalligraphyConfig: CalligraphyConfig? = null

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector



    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        AppLogger.init()

        AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }
     //   CalligraphyConfig.initDefault(mCalligraphyConfig)
    }
}