package com.tonykazanjian.dogapi.ui

import android.os.Bundle
import android.os.Parcelable
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tonykazanjian.dogapi.DogApplication
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.databinding.ActivityMainBinding
import com.tonykazanjian.dogapi.viewModels.ListViewModel

class MainActivity : BaseActivity(), BaseListAdapter.OnBreedClickListener {

    private lateinit var listViewModel: ListViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val recyclerView = activityMainBinding.breedRecyclerView
        val adapter = BreedsListAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL) as RecyclerView.ItemDecoration)

        activityMainBinding.lifecycleOwner = this

        listViewModel = ViewModelProviders.of(this, viewModeFactory).get(ListViewModel::class.java)
        activityMainBinding.viewModel = listViewModel

        listViewModel.getBreedsLiveData().observe(this, Observer<List<DataClasses.Breed>>{ breeds ->
            breeds?.let { adapter.setItems(it) }
        })

        (application as DogApplication).appComponent.inject(this)
    }

//    override fun onBreedClicked(breed: DataClasses.Breed) {
//        val fragmentManager = supportFragmentManager
//        val args = Bundle()
//        args.putParcelable(Navigator.BREED_KEY, breed)
//        val fragment =  BreedDetailFragment.newInstance()
//        fragment.arguments = args
//        val ft = fragmentManager.beginTransaction()
//        ft.add(activityMainBinding.root.id, fragment, BreedDetailFragment.TAG)
//        ft.addToBackStack(BreedDetailFragment.TAG)
//        ft.commit()
//    }

    override fun onBreedClicked(item: Any?) {
        val fragmentManager = supportFragmentManager
        val args = Bundle()
        args.putParcelable(Navigator.BREED_KEY, item as Parcelable?)
        val fragment =  BreedDetailFragment.newInstance()
        fragment.arguments = args
        val ft = fragmentManager.beginTransaction()
        ft.add(activityMainBinding.root.id, fragment, BreedDetailFragment.TAG)
        ft.addToBackStack(BreedDetailFragment.TAG)
        ft.commit()    }
}
