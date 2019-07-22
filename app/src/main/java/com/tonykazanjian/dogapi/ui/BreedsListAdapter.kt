package com.tonykazanjian.dogapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.databinding.BreedItemBinding
import com.tonykazanjian.dogapi.viewModels.BaseViewModel
import com.tonykazanjian.dogapi.viewModels.ItemViewModel

/**
 * @author Tony Kazanjian
 */
class BreedsListAdapter(override var clickListener: OnBreedClickListener? = null) : BaseListAdapter<DataClasses.Breed>() {

    override var list: List<DataClasses.Breed> = listOf()

    override fun initViewHolder(binding: BreedItemBinding, clickListener: OnBreedClickListener?): ViewHolder<DataClasses.Breed> {
        return BreedViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class BreedViewHolder(override var binding: BreedItemBinding, override var clickListener: OnBreedClickListener?):
        ViewHolder<DataClasses.Breed>(binding, clickListener){

        override fun baseViewModel(item: DataClasses.Breed): BaseViewModel<DataClasses.Breed> {
            return ItemViewModel(item)
        }
    }
}