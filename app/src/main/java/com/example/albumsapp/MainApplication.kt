package com.example.albumsapp

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp


/**
 *Created by haskhiri on 18/10/2021
 */
@HiltAndroidApp
class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}