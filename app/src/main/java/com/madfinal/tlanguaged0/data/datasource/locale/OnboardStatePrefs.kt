package com.madfinal.tlanguaged0.data.datasource.locale

import android.annotation.SuppressLint
import android.content.Context

class OnboardStatePrefs(context: Context) {
    private val sharedPrefs = context.getSharedPreferences("OnboardState", Context.MODE_PRIVATE)

    @SuppressLint("UseKtx")
    fun saveState(currentState: Int) {
        sharedPrefs
            .edit()
            .putInt("currentState", currentState)
            .apply()
    }
}