package com.example.draven.ui.sign

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.draven.R
import com.example.draven.base.BaseActivity
import com.example.draven.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private lateinit var activityLauncher: ActivityResultLauncher<Intent>
    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()
    private val client = GoogleSignIn.getClient(this, gso)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    try {
                        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                        val account = task.result
                    } catch (e: ApiException) {
                        e.printStackTrace()
                    }
                }
            }
    }

    fun onLogin() = activityLauncher.launch(client.signInIntent)
}