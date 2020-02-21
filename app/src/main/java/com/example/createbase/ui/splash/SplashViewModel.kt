package com.example.createbase.ui.splash

import com.example.createbase.data.DataManager
import com.example.createbase.ui.base.BaseViewModel
import com.example.createbase.utils.rx.SchedulerProvider
import javax.inject.Inject

class SplashViewModel@Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<SplashNavigator>(dataManager, schedulerProvider) {

    fun startSeeding() {
//        compositeDisposable.add(
//            dataManager()
//                .seedDatabaseQuestions()
//                .flatMap({ aBoolean -> getDataManager().seedDatabaseOptions() })
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(
//                    { aBoolean -> decideNextActivity() },
//                    { throwable -> decideNextActivity() })
//        )
        decideNextActivity()
    }

     fun decideNextActivity() {
        navigator?.openLoginActivity()
//        if (dataManager.getCurrentUserLoggedInMode() === DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
//            getNavigator().openLoginActivity()
//        } else {
//            getNavigator().openMainActivity()
//        }
    }
}
