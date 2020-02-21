package com.example.createbase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.createbase.data.DataManager
import com.example.createbase.ui.splash.SplashViewModel
import com.example.createbase.utils.rx.SchedulerProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

//@Singleton
//class ViewModelProviderFactory @Inject constructor(

//) : ViewModelProvider.NewInstanceFactory() {
//
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(SplashViewModel::class.java!!)) {
//            return SplashViewModel(dataManager, schedulerProvider) as T
//        }
//
//        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
//    }
//}

class ViewModelProviderFactory @Inject constructor(      val dataManager: DataManager,
                                                         val schedulerProvider: SchedulerProvider,val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")

        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
//@Suppress("UNCHECKED_CAST")
//class ViewModelProviderFactory @Inject constructor(private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
//    ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        val creator = viewModelsMap[modelClass] ?:
//        viewModelsMap.asIterable().firstOrNull {
//            modelClass.isAssignableFrom(it.key)
//        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
//        return try {
//            creator.get() as T
//        } catch (e: Exception) {
//            throw RuntimeException(e)
//        }
//    }
//
//}