package com.example.easyjobs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easyjobs.R
import com.example.easyjobs.databinding.FragmentCreateAdsBinding
import com.example.easyjobs.utils.DialogSpinnerHelper


class CreateAdsFragment : BaseFragment() {
    private var binding: FragmentCreateAdsBinding? = null
    private val dialog = DialogSpinnerHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateAdsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.tvSelectCategory?.setOnClickListener {
            val list = resources.getStringArray(R.array.category_name).toMutableList() as ArrayList
            //binding?.tvSelectCategory?.let { activity?.let { it1 -> dialog.showSpinnerDialog(it1.applicationContext, list, it) } }
            dialog.showSpinnerDialog(requireContext(),list, binding!!.tvSelectCategory)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = CreateAdsFragment()
    }
}