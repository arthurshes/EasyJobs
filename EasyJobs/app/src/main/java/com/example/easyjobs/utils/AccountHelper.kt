package com.example.easyjobs.utils

import android.util.Log
import android.widget.Toast
import com.example.easyjobs.R
import com.example.easyjobs.Splash.activities.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.GoogleAuthProvider

class AccountHelper(private val act:MainActivity) {
    lateinit var signInClient: GoogleSignInClient

    private fun getSignInClientGoogle(): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(act.getString(R.string.default_web_client_i)).requestEmail().build()
        return GoogleSignIn.getClient(act, gso)
    }

    fun signInWithGoogle() {
        signInClient = getSignInClientGoogle()
        val intent = signInClient.signInIntent
        act.lunchActGoogle.launch(intent)
    }

    fun signOutGoogle() {
        getSignInClientGoogle().signOut()
    }

    fun signInFirebaseWithGoogle(token: String) {
        val credential = GoogleAuthProvider.getCredential(token, null)
        act.myAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                act.myAuth.signInWithCredential(credential).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            act,
                            "sign in done",
                            Toast.LENGTH_SHORT
                        ).show()
                       // act.uiUpdate(task.result?.user)
                    } else {
                        Log.d("MyLog", "google sign in Exception: ${task.exception}")
                    }
                }
            }
        }
    }
}