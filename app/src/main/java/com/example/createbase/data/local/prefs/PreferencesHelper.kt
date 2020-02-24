package com.example.createbase.data.local.prefs

import com.example.createbase.data.DataManager

interface PreferencesHelper {

//    abstract fun getAccessToken(): String
//
//    abstract fun setAccessToken(accessToken: String)
//
//    abstract fun getCurrentUserEmail(): String
//
//    abstract fun setCurrentUserEmail(email: String)
//
//    abstract fun getCurrentUserId(): Long?
//
//    abstract fun setCurrentUserId(userId: Long?)

    abstract fun getCurrentUserLoggedInMode(): Int

    abstract fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode)
//
//    abstract fun getCurrentUserName(): String
//
//    abstract fun setCurrentUserName(userName: String)

}
