package com.tonykazanjian.dogapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.databinding.DialogFragmentWelcomeBinding

/**
 * @author Tony Kazanjian
 */
class WelcomeDialog : DialogFragment() {

    lateinit var welcomeBinding : DialogFragmentWelcomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        welcomeBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.dialog_fragment_welcome, container, false)
        return welcomeBinding.root
    }

    companion object{
        fun newInstance() = WelcomeDialog()
        val TAG = WelcomeDialog::class.java.canonicalName

    }
}