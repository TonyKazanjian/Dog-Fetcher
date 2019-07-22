package com.tonykazanjian.dogapi.ui.adapters

import com.tonykazanjian.dogapi.databinding.BreedItemBinding
import com.tonykazanjian.dogapi.viewModels.BaseBreedViewModel
import com.tonykazanjian.dogapi.viewModels.SubBreedViewModel

/**
 * @author Tony Kazanjian
 */
class SubBreedAdapter(override var clickListener: OnBreedClickListener? = null): BaseListAdapter<String>() {

    override var list: List<String> = listOf()

    override fun initViewHolder(binding: BreedItemBinding, clickListener: OnBreedClickListener?): ViewHolder<String> {
        return BreedViewHolder(binding, clickListener)
    }

    class BreedViewHolder(override var binding: BreedItemBinding, override var clickListener: OnBreedClickListener?):
        ViewHolder<String>(binding, clickListener){

        override fun createViewModel(item: String): BaseBreedViewModel<String> {
            return SubBreedViewModel(item)
        }
    }
}