package com.tonykazanjian.dogapi.ui

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.databinding.ActivityDetailBinding
import com.tonykazanjian.dogapi.viewModels.BaseViewModel
import com.tonykazanjian.dogapi.viewModels.DetailViewModel

/**
 * @author Tony Kazanjian
 */
class DetailActivity : BaseActivity() {

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        var detailActivityDetailBinding : ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        var recyclerView = detailActivityDetailBinding.subBreedRecyclerView
        var viewPager = detailActivityDetailBinding.viewPager
        var breedAdapter = BreedImageAdapter(this)
        viewPager.adapter = breedAdapter

        detailViewModel = ViewModelProviders.of(this, viewModeFactory).get(DetailViewModel::class.java)
        detailActivityDetailBinding.viewModel = detailViewModel
        detailViewModel.getImageUrlLiveData().observe(this, Observer<List<String>>{ images ->
            images?.let {
                breedAdapter.setImages(it)
            }
        })

    }
}