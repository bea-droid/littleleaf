package com.example.plantapp.di

import android.app.Application
import dagger.Component
import dagger.hilt.android.HiltAndroidApp

@Component
interface ApplicationComponent {
}

// appComponent lives in the Application class to share its lifecycle
@HiltAndroidApp
class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
//    val appComponent = DaggerApplicationComponent.create()
}