package com.example.createbase.ui.home


import com.example.createbase.data.DataManager
import com.example.createbase.ui.base.BaseViewModel
import com.example.createbase.utils.rx.SchedulerProvider

import javax.inject.Inject

class HomeViewModel @Inject constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<HomeNavigator>(dataManager, schedulerProvider) {
    fun logout() {

    }
}
