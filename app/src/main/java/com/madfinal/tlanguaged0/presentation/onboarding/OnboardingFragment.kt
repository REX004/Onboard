package com.madfinal.tlanguaged0.presentation.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.madfinal.tlanguaged0.R
import com.madfinal.tlanguaged0.databinding.FragmentOnboardingBinding
import com.madfinal.tlanguaged0.presentation.common.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyClick()
        observeState()
    }

    private val viewModel: OnboardingViewModel by viewModel()
    private fun applyClick() {
        binding.nextBt.setOnClickListener {
            viewModel.next()
        }
        binding.loginBt.setOnClickListener {
        }
    }

    private fun observeState() {
        viewModel.currentItem.observe(viewLifecycleOwner) { item ->
            if (item == null) {
                binding.loginBt.apply {
                    setOnClickListener {
                        findNavController().navigate(R.id.loginFragment)
                    }
                }
            } else {
                showNewItem(item)
                binding.nextBt.text = if (viewModel.remainingItems() == 0) "Sign up" else "Next"
            }
        }
    }

    private fun showNewItem(onboardItem: OnbordingItem) {
        binding.apply {
            title.text = onboardItem.title
            description.text = onboardItem.description
            image.setImageResource(onboardItem.image)
            statusBar.setImageResource(onboardItem.status)
        }
    }
}