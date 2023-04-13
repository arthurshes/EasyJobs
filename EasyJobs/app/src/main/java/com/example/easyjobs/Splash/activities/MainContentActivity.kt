package com.example.easyjobs.Splash.activities

import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.easyjobs.fragments.FragmentManager
import com.example.easyjobs.R
import com.example.easyjobs.databinding.ActivityMainContentBinding
import com.example.easyjobs.fragments.AccountFragment
import com.example.easyjobs.fragments.AdsFragment
import com.example.easyjobs.fragments.ChatFragment
import com.example.easyjobs.utils.ToastHelper.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainContentActivity : AppCompatActivity() {
    private var binding: ActivityMainContentBinding? = null
    lateinit var navController: NavController
    var navHostFragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainContentBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setButNavView()
        binding?.toolbar?.title = getString(R.string.tinder_job)

        //navController=Navigation.findNavController(this,R.id.fragment_container)
//        navHostFragment=supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
//        navController = (navHostFragment as NavHostFragment).navController

    }

    private fun setButNavView() {
        binding?.bottomPanel?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.id_tinder_job -> {
                    showToast("tinder_job", this@MainContentActivity)
                    binding?.toolbar?.title = getString(R.string.tinder_job)
                    // binding?.fragmentContainer.visibility = View.GONE
                    true
                }
                R.id.adsFragment -> {
                    binding?.toolbar?.title = getString(R.string.all)
                    //fragmentContainer.visibility = View.VISIBLE
                      FragmentManager.setFragment(AdsFragment.newInstance(),this@MainContentActivity)
                   /* val navController = findNavController(R.id.fragmentContainerView)
                    binding?.bottomPanel?.setupWithNavController(navController)*/
                    true
                }
                R.id.id_favorite -> {
                    showToast("favorite", this@MainContentActivity)
                    binding?.toolbar?.title = getString(R.string.favorite)
                    //fragmentContainer.visibility = View.GONE
                    true
                }
                R.id.chatFragment -> {
                    FragmentManager.setFragment(
                        ChatFragment.newInstance(),
                        this@MainContentActivity
                    )
                    true
                }
                R.id.accountFragment -> {
                    showToast("account", this@MainContentActivity)
                    //  fragmentContainer.visibility = View.GONE
                    FragmentManager.setFragment(AccountFragment.newInstance(), this@MainContentActivity)
                    binding?.toolbar?.title = getString(R.string.account)
                    true
                }else -> {
                    true
                }
            }
        }
    }
}