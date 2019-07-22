package com.tonykazanjian.dogapi.ui.adapters

import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.databinding.BreedItemBinding
import com.tonykazanjian.dogapi.viewModels.BaseBreedViewModel
import com.tonykazanjian.dogapi.viewModels.MainBreedViewModel

/**
 * @author Tony Kazanjian
 */
class BreedsListAdapter(override var clickListener: OnBreedClickListener? = null) : BaseListAdapter<DataClasses.Breed>() {

    override var list: List<DataClasses.Breed> = listOf()

    override fun initViewHolder(binding: BreedItemBinding, clickListener: OnBreedClickListener?): ViewHolder<DataClasses.Breed> {
        return BreedViewHolder(binding, clickListener)
    }

    class BreedViewHolder(override var binding: BreedItemBinding, override var clickListener: OnBreedClickListener?):
        ViewHolder<DataClasses.Breed>(binding, clickListener){

        override fun createViewModel(item: DataClasses.Breed): BaseBreedViewModel<DataClasses.Breed> {
            return MainBreedViewModel(item)
        }
    }
}