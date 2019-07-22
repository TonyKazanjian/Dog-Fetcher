package com.tonykazanjian.dogapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonykazanjian.dogapi.NavigationUtils
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.databinding.FragmentDetailBinding
import com.tonykazanjian.dogapi.ui.adapters.BaseListAdapter
import com.tonykazanjian.dogapi.ui.adapters.BreedImageAdapter
import com.tonykazanjian.dogapi.ui.adapters.SubBreedAdapter
import com.tonykazanjian.dogapi.viewModels.DetailViewModel

/**
 * @author Tony Kazanjian
 */
class BreedDetailFragment: BaseFragment(), BaseListAdapter.OnBreedClickListener {

    companion object{
        val TAG = BreedDetailFragment::class.java.canonicalName
        fun newInstance(): BreedDetailFragment {
            return BreedDetailFragment()
        }
    }

    lateinit var binding: FragmentDetailBinding

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val imageAdapter = initViewPager()
        initViewModel(binding, imageAdapter)
        initSubBreedRecyclerView()

        return binding.root
    }

    private fun initViewPager(): BreedImageAdapter {
        val viewPager = binding.viewPager
        val imageAdapter = BreedImageAdapter(context)
        viewPager.adapter = imageAdapter
        return imageAdapter
    }

    private fun initSubBreedRecyclerView() {
        val recyclerView = binding.subBreedRecyclerView
        val subBreedAdapter = SubBreedAdapter(this)
        recyclerView.adapter = subBreedAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        setBreedInfoToAdapter(subBreedAdapter)
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

    private fun getBreedFromArgs() : DataClasses.Breed {
        val breed: DataClasses.Breed
        val args = arguments
        breed = args?.get(NavigationUtils.BREED_KEY) as DataClasses.Breed
        return breed
    }

    override fun onBreedClicked(item: Any?) {
        val fragmentManager = fragmentManager
        val args = Bundle()

        args.putString(NavigationUtils.SUB_BREED_KEY, item as String?)
        args.putParcelable(NavigationUtils.BREED_KEY, detailViewModel.breed)

        val fragment =  SubBreedImageFragment.newInstance()
        fragment.arguments = args

        val ft = fragmentManager!!.beginTransaction()
        ft.add(binding.root.id, fragment, SubBreedImageFragment.TAG)
        ft.addToBackStack(SubBreedImageFragment.TAG)
        ft.commit()
    }

}