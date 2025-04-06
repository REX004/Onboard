package com.madfinal.tlanguaged0.domain.onboarding.usecase

import com.madfinal.tlanguaged0.domain.onboarding.repository.OnboardingRepository
import com.madfinal.tlanguaged0.presentation.onboarding.OnbordingItem

class GetOnboardingItemsUseCase(
    private val repository: OnboardingRepository
) {
    operator fun invoke(): List<OnbordingItem> {
        return repository.getOnboardingQueue()
    }
}