package com.example.createbase.data

import com.example.createbase.data.local.db.DbHelper
import com.example.createbase.data.local.prefs.PreferencesHelper
import com.example.createbase.data.remote.ApiHelper
import io.reactivex.Observable
import io.reactivex.Single

interface DataManager : DbHelper, PreferencesHelper, ApiHelper {

    abstract fun seedSplashDelay(): Observable<Boolean>
    abstract fun doLoginGoogleCall():Single<Boolean>
    abstract fun setUserAsLoggedOut()
    abstract fun updateUserInfo(
        loggedInMode: LoggedInMode
    )

    enum class LoggedInMode private constructor(val type: Int) {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}
