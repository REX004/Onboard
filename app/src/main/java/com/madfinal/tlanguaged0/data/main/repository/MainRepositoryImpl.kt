package com.madfinal.tlanguaged0.data.main.repository

import com.madfinal.tlanguaged0.data.datasource.network.supabase.api.SupabaseApi
import com.madfinal.tlanguaged0.domain.main.repository.MainRepository
import com.madfinal.tlanguaged0.domain.models.User
import io.reactivex.rxjava3.core.Single

class MainRepositoryImpl(
    private val api: SupabaseApi,

) : MainRepository {
    override fun loadTopUsers(): Single<List<User>> {
        return api.getTopUsers()
    }
}