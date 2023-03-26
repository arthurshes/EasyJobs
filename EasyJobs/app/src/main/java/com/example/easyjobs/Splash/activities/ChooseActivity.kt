package com.example.easyjobs.Splash.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.easyjobs.databinding.ChooseActivityBinding
import com.example.easyjobs.viewModels.SignInViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChooseActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private val viewModel: SignInViewModel by viewModels()
    private lateinit var binding: ChooseActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ChooseActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAuth= FirebaseAuth.getInstance()
        //binding.btnEmployer.setOnClickListener {  chooseEmployer() }
        //binding.btnWorker.setOnClickListener {chooseWorker()  }
///
        binding.apply {
            buttonReg.setOnClickListener {
                if (editTextTextPersonName.text.isNotEmpty()&&editTextTextPersonName2.text.isNotEmpty()&&editTextTextPersonName3.text.isNotEmpty()){
                    SignIn(token = mAuth.currentUser!!.uid,name = editTextTextPersonName.text.toString(),age=editTextTextPersonName2.text.toString().toInt(), town = editTextTextPersonName3.text.toString())
                }
            }
        }
    }
    ///izmenen
    ///
    private fun SignIn(token:String,name:String,age:Int,town:String) {
        CoroutineScope(Dispatchers.IO ).launch {
            viewModel.signIn(token,name, age, town).let {
                if (it){
                    Toast.makeText(applicationContext,"Успешная регистрация", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun chooseWorker(){

    }
    private fun chooseEmployer(){

    }
}