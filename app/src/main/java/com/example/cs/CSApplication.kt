package com.example.cs

import android.app.Application
import com.example.cs.data.Storage

class CSApplication : Application() {
    override fun onCreate() {
        Storage.context = this
        super.onCreate()
    }
}