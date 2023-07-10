package ru.netology.maps.application

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MapsApplication : Application() {
    private val API_KEY: String = "00000000-0000-0000-0000-000000000000"

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(API_KEY)
    }
}