package ru.netology.maps.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.maps.R
import ru.netology.maps.databinding.FragmentMapsBinding
import ru.netology.maps.utils.Companion.Companion.idPoint
import ru.netology.maps.utils.Companion.Companion.latitude
import ru.netology.maps.utils.Companion.Companion.longitude
import ru.netology.maps.utils.Companion.Companion.zoom

@AndroidEntryPoint
class MapsFragment : Fragment() {

    private lateinit var binding: FragmentMapsBinding
    private val latitudeMap = arguments?.latitude ?: 59.945933
    private val longitudeMap = arguments?.longitude ?: 30.320045

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(layoutInflater)
        val map = binding.mapview.map
        val zoomMap = arguments?.zoom ?: 8.0f
        map.move(
            CameraPosition(Point(latitudeMap, longitudeMap), zoomMap, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5F),
            null
        )

        map.addCameraListener { _, cameraPosition, _, _ ->

            binding.point.setOnLongClickListener {
                val point = cameraPosition.target
                findNavController().navigate(
                    R.id.action_mapsFragment_to_fragmentNewPoint,
                    Bundle().apply {
                        latitude = point.latitude
                        longitude = point.longitude
                        idPoint = 0
                    }
                )
                true
            }
        }


        return binding.root
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}