package com.example.createbase.ui.login

import android.text.TextUtils
import com.example.createbase.data.DataManager
import com.example.createbase.ui.base.BaseViewModel
import com.example.createbase.utils.CommonUtils
import com.example.createbase.utils.rx.SchedulerProvider
import javax.inject.Inject

class LoginViewModel @Inject constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<LoginNavigator>(dataManager, schedulerProvider) {

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

    fun login(email: String, password: String) {
        setIsLoading(true)
//        compositeDisposable.add(dataManager.
//            .doServerLoginApiCall(LoginRequest.ServerLoginRequest(email, password))
//            .doOnSuccess({ response ->
//                getDataManager()
//                    .updateUserInfo(
//                        response.getAccessToken(),
//                        response.getUserId(),
//                        DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
//                        response.getUserName(),
//                        response.getUserEmail(),
//                        response.getGoogleProfilePicUrl()
//                    )
//            })
//            .subscribeOn(getSchedulerProvider().io())
//            .observeOn(getSchedulerProvider().ui())
//            .subscribe({ response ->
//                setIsLoading(false)
//                getNavigator().openMainActivity()
//            }, { throwable ->
//                setIsLoading(false)
//                getNavigator().handleError(throwable)
//            })
//        )
        navigator?.openMainActivity()
    }

    fun onFbLoginClick() {
//        setIsLoading(true)
//        getCompositeDisposable().add(getDataManager()
//            .doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest("test3", "test4"))
//            .doOnSuccess({ response ->
//                getDataManager()
//                    .updateUserInfo(
//                        response.getAccessToken(),
//                        response.getUserId(),
//                        DataManager.LoggedInMode.LOGGED_IN_MODE_FB,
//                        response.getUserName(),
//                        response.getUserEmail(),
//                        response.getGoogleProfilePicUrl()
//                    )
//            })
//            .subscribeOn(getSchedulerProvider().io())
//            .observeOn(getSchedulerProvider().ui())
//            .subscribe({ response ->
//                setIsLoading(false)
//                getNavigator().openMainActivity()
//            }, { throwable ->
//                setIsLoading(false)
//                getNavigator().handleError(throwable)
//            })
//        )
    }

    fun onGoogleLoginClick() {

    }

    fun onServerLoginClick() {

    }
}
