package com.example.easyjobs.fragments

import androidx.appcompat.app.AppCompatActivity
import com.example.easyjobs.R

object FragmentManager {

  //  var currentFrag: BaseFragment? = null

    fun setFragment(newFragment: BaseFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.place_holder, newFragment)
        transaction.commit()
       // currentFrag=newFragment
    }
}