package com.example.createbase.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.createbase.R
import com.example.createbase.BR
import com.example.createbase.ViewModelProviderFactory
import com.example.createbase.databinding.ActivityLoginBinding
import com.example.createbase.ui.base.BaseActivity
import com.example.createbase.ui.home.HomeActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigator,GoogleApiClient.OnConnectionFailedListener {


    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var mLoginViewModel: LoginViewModel? = null
    private var mActivityLoginBinding: ActivityLoginBinding? = null
    val REQUESTCODE_LOGIN_GOOOGLE=100
    lateinit var apiClient : GoogleApiClient
    var PROVIDER_DANGNHAP=0
    val firebaseAuth: FirebaseAuth =FirebaseAuth.getInstance()


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_login

    override val viewModel: LoginViewModel
        get() {
            mLoginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
            return mLoginViewModel!!
        }

    override fun handleError(throwable: Throwable) {

    }

    override fun loginGG() {
        PROVIDER_DANGNHAP = 1
        val intentGG = Auth.GoogleSignInApi.getSignInIntent(apiClient)
        startActivityForResult(intentGG, REQUESTCODE_LOGIN_GOOOGLE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUESTCODE_LOGIN_GOOOGLE) {
            if (resultCode == Activity.RESULT_OK) {
                val signInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
                val googleSignInAccount = signInResult.signInAccount
                val tokenID = googleSignInAccount!!.idToken
                apiClient.clearDefaultAccountAndReconnect()
                ProvideFirebase(tokenID!!)
                Log.d("kiemtra","hello")
                Log.d("kiemtra",""+firebaseAuth.currentUser?.uid)
//                val intent = Intent(this,GiaHanThietBiActivity::class.java)
//                startActivity(intent)
//                finish()
            }
        }
    }
    private fun ProvideFirebase(tokenid: String) {

        if (PROVIDER_DANGNHAP == 1) {
            val authCredential = GoogleAuthProvider.getCredential(tokenid, null)
            firebaseAuth.signInWithCredential(authCredential)
            viewModel.updateUserInfo()
        }

    }

    override fun onStart() {
        super.onStart()

    }


    override fun openMainActivity() {
        val intent = HomeActivity.newIntent(this)
        startActivity(intent)
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLoginBinding = viewDataBinding
        mLoginViewModel!!.navigator=this
        CreateClientLoginGG()
    }

    fun CreateClientLoginGG(){
        val signInOptions = GoogleSignInOptions.Builder()
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        apiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
            .build()
    }
    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.d("kiemtra",""+p0.errorMessage)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
