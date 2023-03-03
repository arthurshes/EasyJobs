package com.example.easyjobs.Splash.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.easyjobs.R
import com.example.easyjobs.databinding.ActivityMainContentBinding

class MainContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setButtNavView()
        binding.toolbar.title=getString(R.string.tinder_job)
    }


    private fun setButtNavView() =with(binding){
        binding.bottomPanel.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.id_tinder_job -> {
                    showToast("tinder_job")
                   toolbar.title=getString(R.string.tinder_job)
                    true
                }
                R.id.id_search_job -> {
                    showToast("search_job")
                    toolbar.title=getString(R.string.search)
                    true
                }
                R.id.id_favorite -> {
                    showToast("favorite")
                    toolbar.title=getString(R.string.favorite)
                    true
                }
                R.id.id_chat -> {
                    showToast("chat")
                    toolbar.title=getString(R.string.chat)
                    true
                }
                R.id.id_account -> {
                    showToast("account")
                    toolbar.title=getString(R.string.account)
                    true
                }
                else -> {
                    true
                }
            }
        }
    }




    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}