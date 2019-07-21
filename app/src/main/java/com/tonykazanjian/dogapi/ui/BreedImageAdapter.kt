package com.tonykazanjian.dogapi.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.databinding.BreedImageBinding



/**
 * @author Tony Kazanjian
 */
class BreedImageAdapter(private val context: Context): PagerAdapter() {

    val imageList = listOf<String>()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageBinding : BreedImageBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.breed_image, container, false)
        val imageView = imageBinding.image
        //TODO - picasso sets imageURL to imageview here

        container.addView(imageBinding.root)
        return imageBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeViewAt(position)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageList.size
    }
}