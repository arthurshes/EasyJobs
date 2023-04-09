package com.example.easyjobs.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.easyjobs.R
import com.example.easyjobs.adapters.AdsAdapter
import com.example.easyjobs.adapters.ChatAdapter
import com.example.easyjobs.databinding.FragmentChatBinding


class ChatFragment : BaseFragment() {
    private lateinit var binding: FragmentChatBinding
    private lateinit var adapter: ChatAdapter
///
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
///
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRc()
    }


    private fun initRc()= with(binding){
        rcViewChat.layoutManager=LinearLayoutManager(activity)
        adapter=ChatAdapter()
        rcViewChat.adapter=adapter
        Log.d("MyLog","${adapter.adArray.size}")
    }
   companion object {
        @JvmStatic
        fun newInstance() = ChatFragment()
    }
}
