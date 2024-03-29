package com.example.easyjobs.adapters



import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.easyjobs.R
import com.example.easyjobs.Splash.activities.MainContentActivity
import com.example.easyjobs.databinding.AdItemBinding
import com.example.easyjobs.fragments.ChatFragment
import com.example.easyjobs.fragments.FragmentManager
import com.example.easyjobs.network.model.admodel.AdWorkerModel


class AdsAdapter(private val adsListener: AdsListener) : ListAdapter<AdWorkerModel, AdsAdapter.ItemHolder>(ItemComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position),adsListener)
    }

    class ItemHolder(view: View,val context: Context) : RecyclerView.ViewHolder(view) {
        private val binding = AdItemBinding.bind(view)
        private val adapter=ChatAdapter()
        fun setData(adWorkerModel: AdWorkerModel,adsListener: AdsListener) = with(binding) {
            tvNameCompany.text=adWorkerModel.firm_name

            btnMassage.setOnClickListener {
                adsListener.insert()
                //FragmentManager.setFragment(ChatFragment.newInstance(), context as MainContentActivity )
                //fragmentContainer.visibility=View.GONE
              /*  adapter.updateAdapter(fillAd(adWorkerModel))
                Log.d("MyLog","${adapter.adArray.size}")*/
            }
        }
        private fun fillAd(ad:AdWorkerModel):AdWorkerModel{
            return AdWorkerModel(
                age_from = ad.age_from,
                age_to = ad.age_to,
                candidat = ad.candidat,
                catalogues = ad.catalogues,
                client_logo = ad.client_logo,
                education = ad.education,
                experience = ad.experience,
                firm_activity = ad.firm_activity,
                firm_name = ad.firm_name,
                id=ad.id,
                payment_from = ad.payment_from,
                payment_to = ad.payment_to,
                phone = ad.phone,
                place_of_work = ad.place_of_work,
                profession = ad.profession,
                town = ad.town,
                type_of_work = ad.type_of_work,
                work=ad.work
            )
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.ad_item, parent, false), parent.context)
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<AdWorkerModel>() {
        override fun areItemsTheSame(oldItem: AdWorkerModel, newItem: AdWorkerModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AdWorkerModel, newItem: AdWorkerModel): Boolean {
            return oldItem == newItem
        }
    }

    interface AdsListener{
        fun insert()
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