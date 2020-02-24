package com.example.createbase.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.createbase.data.remote.ApiHelper
import com.example.createbase.data.remote.AppApiHelper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton
import com.example.createbase.BuildConfig
import com.example.createbase.R
import com.example.createbase.data.AppDataManager
import com.example.createbase.data.DataManager
import com.example.createbase.data.local.db.AppDatabase
import com.example.createbase.data.local.db.AppDbHelper
import com.example.createbase.data.local.db.DbHelper
import com.example.createbase.data.local.prefs.AppPreferencesHelper
import com.example.createbase.data.local.prefs.PreferencesHelper
import com.example.createbase.data.remote.ApiHeader
import com.example.createbase.di.ApiInfo
import com.example.createbase.di.DatabaseInfo
import com.example.createbase.di.PreferenceInfo
import com.example.createbase.utils.AppConstants
import com.example.createbase.utils.rx.SchedulerProvider

@Module
class AppModule {

//    @Provides
//    @Singleton
//     fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
//        return appApiHelper
//    }
//
//    @Provides
//    @ApiInfo
//     fun provideApiKey(): String {
//        return "link api"
//    }

//    @Provides
//    @Singleton
//     fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
//        return Room.databaseBuilder(context, AppDatabase::class.java!!, dbName)
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//
//    @Provides
//    @Singleton
//     fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
//        return CalligraphyConfig.Builder()
//            .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//            .setFontAttrId(R.attr.fontPath)
//            .build()
//    }

    @Provides
    @Singleton
     fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
     fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

//    @Provides
//    @DatabaseInfo
//     fun provideDatabaseName(): String {
//        return AppConstants.DB_NAME
//    }

//    @Provides
//    @Singleton
//     fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
//        return appDbHelper
//    }

    @Provides
    @Singleton
     fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @PreferenceInfo
     fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }
//
    @Provides
    @Singleton
     fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

//    @Provides
//    @Singleton
//     fun provideProtectedApiHeader(
//        @ApiInfo apiKey: String,
//        preferencesHelper: PreferencesHelper
//    ): ApiHeader.ProtectedApiHeader {
//        return ApiHeader.ProtectedApiHeader(
//            apiKey,
//            1234567,//preferencesHelper.getCurrentUserId(),
//            "token"//preferencesHelper.getAccessToken()
//        )
//    }

    @Provides
     fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}
