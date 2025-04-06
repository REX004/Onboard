package com.madfinal.tlanguaged0.data.datasource.locale

import android.content.Context

class UserPrefs(
    private val context: Context
) {
    private val sharesPrefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


}