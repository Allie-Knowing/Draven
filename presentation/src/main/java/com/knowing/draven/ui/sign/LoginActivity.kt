package com.knowing.draven.ui.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.knowing.draven.R
import com.knowing.draven.databinding.ActivityLoginBinding
import com.knowing.draven.base.BaseActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.Scopes
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.knowing.draven.BuildConfig

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private lateinit var activityLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this

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
                        Log.d("TAG", account.serverAuthCode.toString())
                    } catch (e: ApiException) {
                        e.printStackTrace()
                    }
                }
            }

        binding.googleLogin.setOnClickListener { activityLauncher.launch(client.signInIntent) }
    }
}