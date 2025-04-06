package com.madfinal.tlanguaged0.domain.main.usecase

import com.madfinal.tlanguaged0.domain.main.repository.MainRepository
import com.madfinal.tlanguaged0.domain.models.User
import io.reactivex.rxjava3.core.Single

class GetTopUsersUseCase(
    private val repository: MainRepository
) {
    fun execute(): Single<List<User>> {
        return repository.loadTopUsers()
    }
}