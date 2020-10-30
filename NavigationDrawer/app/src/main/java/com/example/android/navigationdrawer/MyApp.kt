package com.example.android.navigationdrawer

import android.app.Application
import timber.log.Timber

class MyApp: Application() {

    override fun onCreate() {
        Timber.plant(Timber.DebugTree())
        super.onCreate()
    }
}