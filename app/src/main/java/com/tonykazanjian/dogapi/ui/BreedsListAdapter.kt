package com.tonykazanjian.dogapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.databinding.BreedItemBinding
import com.tonykazanjian.dogapi.viewModels.ItemViewModel

/**
 * @author Tony Kazanjian
 */
class BreedsListAdapter(var clickListener: OnBreedClickListener? = null): RecyclerView.Adapter<BreedsListAdapter.ViewHolder>() {

    var breedsList = listOf<DataClasses.Breed>()

    interface OnBreedClickListener {
        fun onBreedClicked(breed: DataClasses.Breed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: BreedItemBinding = DataBindingUtil.inflate(inflater, R.layout.breed_item, parent, false)
        return ViewHolder(binding, clickListener)
    }

    override fun getItemCount(): Int {
        return breedsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(breedsList[position])
    }

    internal fun setBreeds(breeds: List<DataClasses.Breed>) {
        this.breedsList = breeds
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: BreedItemBinding, val clickListener: OnBreedClickListener?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(breed: DataClasses.Breed) {
            val itemViewModel = ItemViewModel(breed)
            binding.viewModel = itemViewModel
            itemView.setOnClickListener{ clickListener?.onBreedClicked(breed)}
        }
    }
}