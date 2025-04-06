package com.madfinal.tlanguaged0.presentation.main

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madfinal.tlanguaged0.domain.main.usecase.GetTopUsersUseCase
import com.madfinal.tlanguaged0.domain.models.User
import com.madfinal.tlanguaged0.presentation.common.UiState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(
    private val topUsersUseCase: GetTopUsersUseCase
) : ViewModel() {

    private val _topUsers = MutableLiveData<UiState<List<User>>>()
    val topUsers: LiveData<UiState<List<User>>> = _topUsers

    @SuppressLint("CheckResult")
    fun getTopUsers() {
        _topUsers.value = UiState.Loading()
        try {
            topUsersUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ users ->
                    _topUsers.value = UiState.Success(users)
                }, { throwable ->
                    _topUsers.value = UiState.Error(throwable.message ?: "Unknown")
                }
                )

            topUsersUseCase.execute()

        } catch (e: Exception) {
            _topUsers.value = UiState.Error("Failed to load data: ${e.message}")
        }
    }
}
