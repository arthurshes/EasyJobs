package com.example.easyjobs.Splash.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.easyjobs.databinding.ChooseActivityBinding

class ChooseActivity : AppCompatActivity() {
    private lateinit var binding: ChooseActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ChooseActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.btnEmployer.setOnClickListener {  chooseEmployer() }
        //binding.btnWorker.setOnClickListener {chooseWorker()  }
    }
    private fun chooseWorker(){

    }
    private fun chooseEmployer(){

    }
}