package com.example.easyjobs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.easyjobs.databinding.FragmentAccountBinding
import com.example.easyjobs.viewModels.SignInViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@AndroidEntryPoint
class AccountFragment : BaseFragment() {
    private var binding: FragmentAccountBinding? = null
    private val viewModel: SignInViewModel by activityViewModels ()
    private lateinit var mAuth: FirebaseAuth
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            binding?.tvName?.text = viewModel.getUser(mAuth.uid).content.name
            binding?.tvAge?.text = viewModel.getUser(mAuth.uid).content.age.toString()
            binding?.tvTown?.text = viewModel.getUser(mAuth.uid).content.town

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragment()
    }
}