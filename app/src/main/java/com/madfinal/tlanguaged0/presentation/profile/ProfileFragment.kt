package com.madfinal.tlanguaged0.presentation.profile

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.madfinal.tlanguaged0.R
import com.madfinal.tlanguaged0.databinding.FragmentProfileBinding
import com.madfinal.tlanguaged0.presentation.common.base.BaseFragment


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyClick()
    }

    private var isDarkTheme: Boolean = false


    private val imageUri =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                val action =
                    ProfileFragmentDirections.actionProfileFragmentToProfileResizeFragment(it.toString());
                findNavController().navigate(action)
            }
        };

    private val cameraUri =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { uri ->
            uri?.let {
                val action =
                    ProfileFragmentDirections.actionProfileFragmentToProfileResizeFragment(it.toString());
                findNavController().navigate(action)
            }
        };


    private fun toggleMode() {
        val newIsDarkMode = !isDarkTheme
        val newMode =
            if (isDarkTheme) AppCompatDelegate.MODE_NIGHT_NO else AppCompatDelegate.MODE_NIGHT_YES

        AppCompatDelegate.setDefaultNightMode(newMode)
    }


    private fun applyClick() {
        binding.changeImageProfile.setOnClickListener {
            imageUri.launch("image/*")
        }
        binding.changeMode.setOnClickListener {
            toggleMode()
        }
    }

}