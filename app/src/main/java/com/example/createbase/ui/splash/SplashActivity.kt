package com.example.createbase.ui.splash

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.createbase.R
import com.example.createbase.BR
import com.example.createbase.ViewModelProviderFactory
import com.example.createbase.databinding.ActivitySplashBinding
import com.example.createbase.ui.base.BaseActivity
import com.example.createbase.ui.home.HomeActivity
import com.example.createbase.ui.login.LoginActivity
import javax.inject.Inject


class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashNavigator {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    var mSplashViewModel: SplashViewModel? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_splash

    override val viewModel: SplashViewModel
        get() {
            mSplashViewModel= ViewModelProviders.of(this,factory).get(SplashViewModel::class.java)
            return mSplashViewModel!!
        }

    override fun openLoginActivity() {
        val intent = LoginActivity.newIntent(this@SplashActivity)
        startActivity(intent)
        finish()
    }

    override fun openMainActivity() {
        val intent = HomeActivity.newIntent(this@SplashActivity)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSplashViewModel!!.navigator=this
        mSplashViewModel!!.startSeeding()
    }
}
