package com.example.easyjobs.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easyjobs.databinding.ChatItemBinding
import com.example.easyjobs.network.model.admodel.AdWorkerModel

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    val adArray = ArrayList<AdWorkerModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val viewBinding = ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return adArray.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.setData(adArray[position])
    }

    class ChatViewHolder(private val binding: ChatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(adWorkerModel: AdWorkerModel) = with(binding){
            tvPersonTitle.text=adWorkerModel.firm_name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newList: List<AdWorkerModel>) {
        adArray.clear()
        adArray.addAll(newList)
        notifyDataSetChanged()
    }
}