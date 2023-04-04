package com.example.easyjobs.Splash.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
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
            buttonWorker.setOnClickListener {
                edPersonName.visibility= View.GONE
                edPersonAge.visibility= View.GONE
                edPersonCity.visibility= View.GONE
                edPersonName2.visibility= View.VISIBLE
                edPersonAge2.visibility= View.VISIBLE
                edPersonCity2.visibility= View.VISIBLE
                buttonWorker.visibility= View.GONE
                buttonEmployer.visibility= View.VISIBLE
                textView2.visibility= View.GONE
                textView3.visibility= View.VISIBLE
                buttonReg.visibility= View.GONE
                buttonReg2.visibility= View.VISIBLE


                if (edPersonName.text.isNotEmpty() &&
                    edPersonAge.text.isNotEmpty() &&
                    edPersonCity.text.isNotEmpty()

                ) {
                    signIn(
                        token = mAuth.currentUser!!.uid,
                        name = edPersonName2.text.toString(),
                        age = edPersonAge2.text.toString().toInt(),
                        town = edPersonCity2.text.toString()
                    )
                }
            }
            buttonEmployer.setOnClickListener {
                edPersonName2.visibility= View.GONE
                edPersonAge2.visibility= View.GONE
                edPersonCity2.visibility= View.GONE
                edPersonName.visibility= View.VISIBLE
                edPersonAge.visibility= View.VISIBLE
                edPersonCity.visibility= View.VISIBLE
                buttonEmployer.visibility= View.GONE
                buttonWorker.visibility= View.VISIBLE
                textView2.visibility= View.VISIBLE
                textView3.visibility= View.GONE
                buttonReg.visibility= View.VISIBLE
                buttonReg2.visibility= View.GONE
                if (edPersonName2.text.isNotEmpty() &&
                    edPersonAge2.text.isNotEmpty() &&
                    edPersonCity2.text.isNotEmpty()
                ) {
                    signIn(
                        token = mAuth.currentUser!!.uid,
                        name = edPersonName2.text.toString(),
                        age = edPersonAge2.text.toString().toInt(),
                        town = edPersonCity2.text.toString()
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