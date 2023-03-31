package com.example.easyjobs.Splash.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.easyjobs.databinding.ActivityMainBinding
import com.example.easyjobs.utils.AccountHelper
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val accountHelper = AccountHelper(this)

      val myAuth = FirebaseAuth.getInstance()

    var lunchActGoogle= registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            if (account != null) {
              //  Log.d("MyLog", "Api 0")
                accountHelper.signInFirebaseWithGoogle(account.idToken!!)
                startActivity(Intent(this, ChooseActivity::class.java))
            }
        } catch (e: ApiException) {
            Log.d("MyLog", "Api error ${e.message}")
        }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
             uiUpdate(myAuth.currentUser)
        /*  val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
              .requestIdToken(getString(R.string.default_web_client_i))
              .requestEmail()
              .build()

          val  mGoogleSignInClient = GoogleSignIn.getClient(this, gso)*/

        binding.textMainGooglesignin.setOnClickListener{
          /* val signInIntent=mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent,REQUEST_CODE)
            signInWithGoogle()*/
            accountHelper.signInWithGoogle()
        }

        binding.btnMainContent.setOnClickListener {
            startActivity(Intent(this, ChooseActivity::class.java))

        }
       // signInWithGoogle()
    }
    private fun uiUpdate(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this, MainContentActivity::class.java))
        }/*else{
            startActivity(Intent(this, MainActivity::class.java))
        }*/
    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {

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
    private fun getSignInClientGoogle(): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_i)).requestEmail().build()
        return GoogleSignIn.getClient(this, gso)
    }


    private fun signInWithGoogle(){
        val mAccount=GoogleSignIn.getLastSignedInAccount(this)
        if (mAccount!=null){
            Toast.makeText(applicationContext,"зарегестрированTEST",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ChooseActivity::class.java))
        }
        signInClient = getSignInClientGoogle()
        val intent = signInClient.signInIntent
        act.lunchActGoogle.launch(intent)
    }
    companion object{
        private const val REQUEST_CODE=2
    }*/

}