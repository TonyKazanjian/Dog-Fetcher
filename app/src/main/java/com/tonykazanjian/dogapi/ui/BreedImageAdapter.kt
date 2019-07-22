package com.tonykazanjian.dogapi.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.databinding.BreedImageBinding

/**
 * @author Tony Kazanjian
 */
class BreedImageAdapter(private val context: Context?): PagerAdapter() {

    var imageList = listOf<String>()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageBinding : BreedImageBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.breed_image, container, false)
        val imageView = imageBinding.image
        Picasso.get().load(imageList[position]).into(imageView)
        container.addView(imageBinding.root)
        return imageBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageList.size
    }

    fun setImages(images: List<String>){
        imageList = images
        notifyDataSetChanged()
    }
}