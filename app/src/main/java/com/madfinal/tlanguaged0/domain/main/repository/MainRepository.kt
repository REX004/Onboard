package com.madfinal.tlanguaged0.domain.main.repository

import com.madfinal.tlanguaged0.domain.models.User
import io.reactivex.rxjava3.core.Single

interface MainRepository {
    fun loadTopUsers(): Single<List<User>>
}