package com.example.easyjobs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.easyjobs.databinding.FragmentAccountBinding
import com.example.easyjobs.viewModels.SignInViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountFragment : BaseFragment() {
    private  var binding: FragmentAccountBinding?=null
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAccountBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun user(){
        lifecycleScope.launch {
            binding?.tvName?.text = viewModel.getUser().name
            binding?.tvAge?.text = viewModel.getUser().age.toString()
            binding?.tvTown?.text = viewModel.getUser().town
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragment()
    }
}