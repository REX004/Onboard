package com.madfinal.tlanguaged0.domain.onboarding.repository

import com.madfinal.tlanguaged0.presentation.onboarding.OnbordingItem

interface OnboardingRepository {
    fun getOnboardingQueue(): List<OnbordingItem>
}
