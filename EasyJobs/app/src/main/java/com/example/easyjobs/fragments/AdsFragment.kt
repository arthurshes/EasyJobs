package com.example.easyjobs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.easyjobs.R
import com.example.easyjobs.Splash.activities.MainContentActivity
import com.example.easyjobs.adapters.AdsAdapter
import com.example.easyjobs.databinding.FragmentAdsBinding
import com.example.easyjobs.viewModels.SignInViewModel

class AdsFragment : Fragment() {
    private var binding: FragmentAdsBinding? = null
    private lateinit var adapter:AdsAdapter
    private val viewModel: SignInViewModel by activityViewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onStart() {
        super.onStart()
        binding?.btnAdd?.setOnClickListener {
            (activity as MainContentActivity).navController.navigate(R.id.action_adsFragment_to_createAdsFragment)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  binding?.rcView?.layoutManager = LinearLayoutManager(activity)
       // binding?.rcView?.adapter = adapter
        observe()
        initRc()

    }

    private fun observe(){
        viewModel.allNotes.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    private fun initRc()=with(binding){
        this?.rcView?.layoutManager = LinearLayoutManager(activity)
        adapter = AdsAdapter()
        this?.rcView?.adapter = adapter
    }
}