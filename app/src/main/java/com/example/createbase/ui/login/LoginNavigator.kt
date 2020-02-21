package com.example.createbase.ui.login

interface LoginNavigator {

    fun handleError(throwable: Throwable)

    fun login()

    fun openMainActivity()
}
