package com.example.api_politicians

import android.app.Application
import com.example.api_politicians.preferences.PreferenceManager

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceManager.init(this)
    }
}