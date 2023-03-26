package com.example.easyjobs.Splash.activities

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easyjobs.R
import com.example.easyjobs.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
           // .requestIdToken(getString(R.string.default_web_client_i))
            .requestEmail()
            .build()

        val  mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.textMainGooglesignin.setOnClickListener{
           val signInIntent=mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent,REQUEST_CODE)
        }

        binding.btnMainContent.setOnClickListener {
            startActivity(Intent(this, ChooseActivity::class.java))
        }
       // signInWithGoogle()
        signInWithGoogle()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == REQUEST_CODE) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {

        try {
            val account = completedTask.getResult(ApiException::class.java)
            startActivity(Intent(this, ChooseActivity::class.java))
            // Signed in successfully, show authenticated UI.
            //updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("MyLog", "signInResult:failed code=" + e.statusCode)
//            updateUI(null)
        }
    }

    private fun signInWithGoogle(){
        val mAccount=GoogleSignIn.getLastSignedInAccount(this)
        if (mAccount!=null){
            Toast.makeText(applicationContext,"зарегестрированTEST",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ChooseActivity::class.java))
        }
    }
    companion object{
        private const val REQUEST_CODE=2
    }

}