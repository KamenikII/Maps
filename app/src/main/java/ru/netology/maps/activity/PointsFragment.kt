package ru.netology.maps.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.maps.R
import ru.netology.maps.adapters.OnInteractionListener
import ru.netology.maps.adapters.PointAdapter
import ru.netology.maps.databinding.FragmentPointsBinding
import ru.netology.maps.dataclass.PointMap
import ru.netology.maps.utils.Companion.Companion.idPoint
import ru.netology.maps.utils.Companion.Companion.latitude
import ru.netology.maps.utils.Companion.Companion.longitude
import ru.netology.maps.utils.Companion.Companion.zoom
import ru.netology.maps.viewmodel.PointViewModel

@AndroidEntryPoint
class PointsFragment : Fragment() {
    private lateinit var binding: FragmentPointsBinding
    private val viewModel: PointViewModel by activityViewModels()
    private lateinit var adapter: PointAdapter

    private val interactionListener = object : OnInteractionListener {
        override fun onEdit(pointMap: PointMap) {
            findNavController().navigate(
                R.id.action_pointsFragment_to_fragmentNewPoint,
                Bundle().apply {
                    latitude = pointMap.latitude
                    longitude = pointMap.longitude
                    idPoint = pointMap.id
                }
            )
        }

        override fun onRemove(pointMap: PointMap) {
            viewModel.removeById(pointMap.id)
        }

        override fun onMove(pointMap: PointMap) {
            findNavController().navigate(
                R.id.action_pointsFragment_to_mapsFragment,
                Bundle().apply {
                    latitude = pointMap.latitude
                    longitude = pointMap.longitude
                    zoom = 15.0f
                }
            )
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPointsBinding.inflate(layoutInflater)
        adapter = PointAdapter(interactionListener)
        binding.list.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_pointsFragment_to_mapsFragment)
        }
        return binding.root
    }
}