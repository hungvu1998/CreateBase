package com.example.createbase.ui.login

import android.content.Context
import android.text.TextUtils
import com.example.createbase.R
import com.example.createbase.data.DataManager
import com.example.createbase.ui.base.BaseViewModel
import com.example.createbase.utils.CommonUtils
import com.example.createbase.utils.rx.SchedulerProvider
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import javax.inject.Inject

class LoginViewModel @Inject constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<LoginNavigator>(dataManager, schedulerProvider) {
    lateinit var apiClient : GoogleApiClient
    fun isEmailAndPasswordValid(email: String, password: String): Boolean {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false
        }
        return !TextUtils.isEmpty(password)
    }
    fun onGoogleLoginClick(){

        navigator?.loginGG()
    }
    fun updateUserInfo(){
        dataManager.updateUserInfo(
            DataManager.LoggedInMode.LOGGED_IN_MODE_FB
        )
        navigator?.openMainActivity()

    }

}
