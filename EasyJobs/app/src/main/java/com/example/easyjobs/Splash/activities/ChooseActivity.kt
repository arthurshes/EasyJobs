package com.example.easyjobs.Splash.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.easyjobs.databinding.ChooseActivityBinding
import com.example.easyjobs.viewModels.SignInViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class ChooseActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private val viewModel: SignInViewModel by viewModels()
    private lateinit var binding: ChooseActivityBinding

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChooseActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAuth = FirebaseAuth.getInstance()
        //binding.btnEmployer.setOnClickListener {  chooseEmployer() }
        //binding.btnWorker.setOnClickListener {chooseWorker()  }

        binding.apply {
            buttonReg.setOnClickListener {
                if (edPersonName.text.isNotEmpty() &&
                    edPersonAge.text.isNotEmpty() &&
                    edPersonCity.text.isNotEmpty()
                ) {
                    signIn(
                        token = mAuth.currentUser!!.uid,
                        name = edPersonName.text.toString(),
                        age = edPersonAge.text.toString().toInt(),
                        town = edPersonCity.text.toString()
                    )
                }
            }
        }
    }

    private fun signIn(token: String, name: String, age: Int, town: String) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.signIn(token, name, age, town).let {
                if (it) {
                    startActivity(Intent(this@ChooseActivity, MainContentActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun chooseWorker() {

    }

    private fun chooseEmployer() {

    }
}