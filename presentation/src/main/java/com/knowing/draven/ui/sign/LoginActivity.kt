package com.knowing.draven.ui.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.knowing.draven.R
import com.knowing.draven.databinding.ActivityLoginBinding
import com.knowing.draven.base.BaseActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.knowing.draven.BuildConfig
import com.knowing.draven.MainActivity
import com.knowing.draven.util.repeatOnStarted
import com.knowing.draven.viewmodel.AuthViewModel
import com.knowing.draven.viewmodel.AuthViewModel.Event
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private val vm: AuthViewModel by viewModels()
    private lateinit var activityLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this

        repeatOnStarted {
            vm.eventFlow.collect { event -> handleEvent(event) }
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(BuildConfig.GOOGLE_CLIENT_ID)
            .requestEmail()
            .build()
        val client = GoogleSignIn.getClient(this, gso)
        client.signOut()

        activityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    try {
                        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                        val account = task.result
                            vm.googleSignIn(account.serverAuthCode.toString())
                    } catch (e: ApiException) {
                        e.printStackTrace()
                    }
                }
            }

        binding.googleLogin.setOnClickListener { activityLauncher.launch(client.signInIntent) }
    }

    private fun handleEvent(event: Event) = when(event){
        is Event.SuccessGoogleSignIn -> {
            moveToMain()
        }
        else -> {}
    }

    private fun moveToMain(){
        val intent = Intent(this@LoginActivity, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }
}