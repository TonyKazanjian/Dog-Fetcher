package com.tonykazanjian.dogapi.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonykazanjian.dogapi.DogApplication
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.databinding.ActivityMainBinding
import com.tonykazanjian.dogapi.viewModels.ListViewModel

class MainActivity : BaseActivity() {

    private lateinit var listViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val recyclerView = activityMainBinding.breedRecyclerView
        val adapter = BreedsListAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        activityMainBinding.lifecycleOwner = this

        listViewModel = ViewModelProviders.of(this, viewModeFactory).get(ListViewModel::class.java)
        activityMainBinding.viewModel = listViewModel

        listViewModel.getBreedsLiveData().observe(this, Observer<List<DataClasses.Breed>>{ breeds ->

            breeds?.let { adapter.setBreeds(it) }
        })

        (application as DogApplication).appComponent.inject(this)
    }
}
