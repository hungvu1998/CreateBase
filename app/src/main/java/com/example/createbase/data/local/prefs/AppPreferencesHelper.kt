package com.example.createbase.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.createbase.data.DataManager
import com.example.createbase.di.PreferenceInfo
import com.example.createbase.utils.AppConstants
import javax.inject.Inject


class AppPreferencesHelper
constructor(context: Context, @PreferenceInfo prefFileName: String) : PreferencesHelper {


     val mPrefs: SharedPreferences

     var accessToken: String?
        get() = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null)
        set(accessToken) = mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply()

     var currentUserEmail: String?
        get() = mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null)
        set(email) = mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply()

     var currentUserId: Long?
        get() {
            val userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)
            return if (userId == AppConstants.NULL_INDEX) null else userId
        }
        set(userId) {
            val id = userId ?: AppConstants.NULL_INDEX
            mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply()
        }

//     val currentUserLoggedInMode: Int
//        get() = mPrefs.getInt(
//            PREF_KEY_USER_LOGGED_IN_MODE,
//            DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type
//        )

     var currentUserName: String?
        get() = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null)
        set(userName) = mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply()

     var currentUserProfilePicUrl: String?
        get() = mPrefs.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null)
        set(profilePicUrl) =
            mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicUrl).apply()

    init {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }

//     fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode) {
//
//    }

    companion object {

         val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"

         val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"

         val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"

         val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"

         val PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL"

         val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
    }
}
