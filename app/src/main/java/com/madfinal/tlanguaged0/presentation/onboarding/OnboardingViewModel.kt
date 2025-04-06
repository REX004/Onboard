package com.madfinal.tlanguaged0.presentation.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madfinal.tlanguaged0.domain.onboarding.usecase.GetOnboardingItemsUseCase

class OnboardingViewModel(
    getItemUseCase: GetOnboardingItemsUseCase
) : ViewModel() {

    private val queue = ArrayDeque(getItemUseCase()) // очередь из элементов
    private val _currentItem = MutableLiveData<OnbordingItem?>()
    val currentItem: LiveData<OnbordingItem?> get() = _currentItem

    // Метод для обработки следующего элемента
    fun next() {
        if (queue.isNotEmpty()) {
            _currentItem.value = queue.removeFirst()
        } else {
            _currentItem.value = null // Если очередь пуста, устанавливаем null
        }
    }

    // Метод для получения количества оставшихся элементов в очереди
    fun remainingItems(): Int = queue.size


}