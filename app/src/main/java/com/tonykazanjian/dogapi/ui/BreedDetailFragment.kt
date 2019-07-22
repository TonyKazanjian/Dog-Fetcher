package com.tonykazanjian.dogapi.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonykazanjian.dogapi.DogApplication
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.dagger.AppComponent
import com.tonykazanjian.dogapi.dagger.ViewModelFactory
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.databinding.FragmentDetailBinding
import com.tonykazanjian.dogapi.viewModels.DetailViewModel
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class BreedDetailFragment: Fragment(), BaseListAdapter.OnBreedClickListener {

    @Inject
    protected lateinit var viewModeFactory: ViewModelFactory

    companion object{
        val TAG = BreedDetailFragment::class.java.canonicalName
        fun newInstance(): BreedDetailFragment {
            return BreedDetailFragment()
        }
    }

    private lateinit var detailViewModel: DetailViewModel
    protected val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity!!.application as DogApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    private fun getBreedFromArgs() : DataClasses.Breed {
        val breed: DataClasses.Breed
        val args = arguments
        breed = args?.get(Navigator.BREED_KEY) as DataClasses.Breed
        return breed
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val fragmentDetailBinding: FragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        val recyclerView = fragmentDetailBinding.subBreedRecyclerView
        val subBreedAdapter = SubBreedAdapter(this)

        recyclerView.adapter = subBreedAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        val viewPager = fragmentDetailBinding.viewPager
        val imageAdapter = BreedImageAdapter(context)
        viewPager.adapter = imageAdapter

        initViewModel(fragmentDetailBinding, imageAdapter)
        setBreedInfoToAdapter(subBreedAdapter)
        return fragmentDetailBinding.root
    }

    private fun initViewModel(fragmentDetailBinding: FragmentDetailBinding, adapter: BreedImageAdapter) {
        detailViewModel = ViewModelProviders.of(this, viewModeFactory).get(DetailViewModel::class.java)
        fragmentDetailBinding.viewModel = detailViewModel

        detailViewModel.getImageUrlLiveData().observe(this, Observer<List<String>>{ images ->
            images?.let {
                adapter.setImages(it)
            }
        })
    }

    private fun setBreedInfoToAdapter(subBreedAdapter: SubBreedAdapter) {
        detailViewModel.breed = getBreedFromArgs()
        subBreedAdapter.setItems(detailViewModel.breed.subBreeds)
    }

    override fun onBreedClicked(item: Any?) {
        Log.d("TONY", "clicked")
    }


}