package com.devduo.countries

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm

@HiltAndroidApp
class AppController : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}