package com.example.easyjobs.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.easyjobs.network.model.admodel.AdWorkerModel

class DiffUtilHelper(val oldList: List<AdWorkerModel>, val newList: List<AdWorkerModel>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}