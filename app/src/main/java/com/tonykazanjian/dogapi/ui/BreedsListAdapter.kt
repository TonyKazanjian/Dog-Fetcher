package com.tonykazanjian.dogapi.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.databinding.BreedItemBinding
import com.tonykazanjian.dogapi.viewModels.ItemViewModel

/**
 * @author Tony Kazanjian
 */
class BreedsListAdapter: RecyclerView.Adapter<BreedsListAdapter.ViewHolder>() {

    var breedsList = listOf<DataClasses.Breed>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BreedItemBinding.inflate(inflater)
        return ViewHolder(binding)
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


    class ViewHolder(val binding: BreedItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(breed: DataClasses.Breed) {
            val itemViewModel = ItemViewModel(breed)
            binding.viewModel = itemViewModel
            itemView.setOnClickListener {
                Log.d("TONY", "${breed.name} clicked, has ${breed.subBreeds.size} subbreeds") }
        }
    }
}