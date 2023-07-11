package ru.netology.maps.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import com.yandex.maps.mobile.BuildConfig
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.maps.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val API_KEY: String = "00000000-0000-0000-0000-000000000000"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey(API_KEY)
        MapKitFactory.initialize(this)

    }
}