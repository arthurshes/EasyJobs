package com.example.easyjobs.adapters



import androidx.recyclerview.widget.RecyclerView
import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.easyjobs.R
import com.example.easyjobs.databinding.AdItemBinding
import com.example.easyjobs.network.model.admodel.AdWorkerModel
import com.example.easyjobs.network.model.modeluser.AdEmployer

class AdsAdapter : ListAdapter<AdWorkerModel, AdsAdapter.ItemHolder>(ItemComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = AdItemBinding.bind(view)
        fun setData(adWorkerModel: AdWorkerModel) = with(binding) {

        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.ad_item, parent, false)
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<AdWorkerModel>() {
        override fun areItemsTheSame(oldItem: AdWorkerModel, newItem: AdWorkerModel): Boolean {
            return oldItem.candidat == newItem.candidat
        }

        override fun areContentsTheSame(oldItem: AdWorkerModel, newItem: AdWorkerModel): Boolean {
            return oldItem == newItem
        }
    }
}



/*RecyclerView.Adapter<AdsAdapter.AdsViewHolder>() {
    val adArray = ArrayList<AdWorkerModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        val viewBinding =
            AdItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdsViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return adArray.size
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        holder.setData(adArray[position])
    }

    class AdsViewHolder(private val binding: AdItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(adWorkerModel: AdWorkerModel) = with(binding){
            binding.tvNameCompany.text =adWorkerModel.candidat
            companyImage.load(adWorkerModel.client_logo)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newList: List<AdWorkerModel>) {
        adArray.clear()
        adArray.addAll(newList)
        notifyDataSetChanged()
    }
}*/