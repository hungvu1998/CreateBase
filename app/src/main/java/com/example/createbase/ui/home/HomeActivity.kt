package com.example.createbase.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.createbase.R
import com.example.createbase.BR
import com.example.createbase.ViewModelProviderFactory
import com.example.createbase.databinding.ActivityHomeBinding
import com.example.createbase.ui.base.BaseActivity
import com.example.createbase.ui.login.LoginActivity
import javax.inject.Inject


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), HomeNavigator {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var mActivityHomeBinding: ActivityHomeBinding? = null
    var mHomeViewModel: HomeViewModel? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_home

    override val viewModel: HomeViewModel
        get() {
            mHomeViewModel= ViewModelProviders.of(this,factory).get(HomeViewModel::class.java)
            return mHomeViewModel!!
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityHomeBinding = viewDataBinding
        mHomeViewModel!!.navigator=this

    }

    override fun openLoginActivity() {
        hideLoading()
        val intent = LoginActivity.newIntent(this@HomeActivity)
        startActivity(intent)
        finish()
    }
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }



}
