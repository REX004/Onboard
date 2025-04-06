package com.madfinal.tlanguaged0.data.onboarding

import com.madfinal.tlanguaged0.R
import com.madfinal.tlanguaged0.domain.onboarding.repository.OnboardingRepository
import com.madfinal.tlanguaged0.presentation.onboarding.OnbordingItem

class OnboardingRepositoryImpl() : OnboardingRepository {
    override fun getOnboardingQueue(): List<OnbordingItem> {
        return listOf(
            OnbordingItem(
                "Title1",
                "description 1",
                R.drawable.onboarding1_img,
                R.drawable.status_onboard1
            ),
            OnbordingItem(
                "Title2",
                "description 2",
                R.drawable.onboarding2_img,
                R.drawable.status_onboard2
            ),
            OnbordingItem(
                "Title3",
                "description 3",
                R.drawable.onboarding3_img,
                R.drawable.status_onboard3
            )
        )
    }
}