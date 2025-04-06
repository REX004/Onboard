package com.madfinal.tlanguaged0.presentation.profile

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import com.madfinal.tlanguaged0.databinding.FragmentProfileResizeBinding
import com.madfinal.tlanguaged0.presentation.common.base.BaseFragment


class ProfileResizeFragment :
    BaseFragment<FragmentProfileResizeBinding>(FragmentProfileResizeBinding::inflate) {

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUri = ProfileResizeFragmentArgs.fromBundle(it).photoUri.toUri()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImageUri()
    }


    private fun setImageUri() {
        binding.profileImage.setImageUriAsync(imageUri)
    }


}