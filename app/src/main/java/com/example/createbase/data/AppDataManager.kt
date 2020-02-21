package com.example.createbase.data

import android.content.Context
import com.example.createbase.data.local.db.DbHelper
import com.example.createbase.data.local.prefs.PreferencesHelper
import com.example.createbase.data.remote.ApiHelper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(
     val mContext: Context
//     val mDbHelper: DbHelper,
//     val mPreferencesHelper: PreferencesHelper,
//     val mApiHelper: ApiHelper,
//     val mGson: Gson
) : DataManager {


    companion object {

         val TAG = "AppDataManager"
    }
}
