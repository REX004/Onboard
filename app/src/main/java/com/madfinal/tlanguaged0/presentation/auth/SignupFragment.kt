package com.madfinal.tlanguaged0.presentation.auth

import android.os.Bundle
import android.view.View
import com.madfinal.tlanguaged0.databinding.FragmentSignupBinding
import com.madfinal.tlanguaged0.presentation.common.base.BaseFragment
import java.io.File


class SignupFragment : BaseFragment<FragmentSignupBinding>(FragmentSignupBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyClick()
    }

    private fun applyClick() {
        binding.apply {
            showBt.setOnClickListener {
                showPdfFile()
            }
            backBt.setOnClickListener {
                binding.pdfContainer.visibility = View.INVISIBLE
            }
        }

    }

    private fun showPdfFile() {
        binding.pdfContainer.visibility = View.VISIBLE
        binding.pdfView.initWithFile(
            filePath()
        )
    }

    private fun filePath(): File {
        val file = File(requireContext().cacheDir, "temp.pdf").apply {
            outputStream().use { output ->
                requireContext().assets.open("terms.pdf").use { it.copyTo(output) }
            }
        }
        return file
    }


}