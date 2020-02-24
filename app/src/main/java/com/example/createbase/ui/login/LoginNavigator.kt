package com.example.createbase.ui.login

import com.google.android.gms.common.api.GoogleApiClient

interface LoginNavigator {

    fun handleError(throwable: Throwable)

    fun loginGG()

    fun openMainActivity()
}
