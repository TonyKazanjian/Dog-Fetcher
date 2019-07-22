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
open class BaseListAdapter<T> (open var clickListener: OnBreedClickListener? = null): RecyclerView.Adapter<BaseListAdapter.ViewHolder<T>>(){

    open var list = listOf<T>()

    protected lateinit var binding: BreedItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(inflater, R.layout.breed_item, parent, false)
        return initViewHolder(binding, clickListener)
    }

    open fun initViewHolder(binding: BreedItemBinding, clickListener: OnBreedClickListener?): ViewHolder<T>{
        return ViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        holder.bind(list[position])
    }

    internal fun setItems(itemList: List<T>) {
        list = itemList
        notifyDataSetChanged()
    }

    interface OnBreedClickListener {
        fun onBreedClicked(item: Any?)
    }

    open class ViewHolder<T>(open val binding: BreedItemBinding, open val clickListener: OnBreedClickListener?) : RecyclerView.ViewHolder(binding.root) {

        open fun bind(item: T) {
            val itemViewModel = baseViewModel(item)
            binding.viewModel = itemViewModel
            itemView.setOnClickListener{ clickListener?.onBreedClicked(item)}
        }

        open fun baseViewModel(item: T) = BaseViewModel(item)
    }
}