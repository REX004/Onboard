package com.madfinal.tlanguaged0.data.datasource.network.supabase.api

import com.madfinal.tlanguaged0.domain.models.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SupabaseApi {

    @GET("rest/v1/users")
    fun getTopUsers(
        @Query("order") order: String = "score.desc",
        @Query("limit") limit: Int = 3
    ): Single<List<User>>
}