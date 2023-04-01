package com.example.easyjobs.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.easyjobs.MainApp
import com.example.easyjobs.databinding.FragmentAccountBinding
import com.example.easyjobs.viewModels.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@AndroidEntryPoint
class AccountFragment : BaseFragment() {
    private var binding: FragmentAccountBinding? = null
    private val viewModel: SignInViewModel by activityViewModels ()
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.btn?.setOnClickListener {}
        user()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun user() {
        CoroutineScope(Dispatchers.IO/* + coroutineExceptionHandler*/).launch {
            binding?.tvName?.text = viewModel.getUser().content.name
            binding?.tvAge?.text = viewModel.getUser().content.age
            binding?.tvTown?.text = viewModel.getUser().content.town
            Log.d("MyLog", viewModel.getUser().message)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragment()
    }
}