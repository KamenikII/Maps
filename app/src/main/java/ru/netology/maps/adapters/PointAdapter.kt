package ru.netology.maps.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.netology.maps.databinding.PointCardBinding
import ru.netology.maps.dataclass.PointMap

class PointAdapter (
    private val onInteractionListener: OnInteractionListener,
) : ListAdapter<PointMap, PointViewHolder>(PointsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        val binding =
            PointCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PointViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        val pointMap = getItem(position)
        holder.renderingPostStructure(pointMap)
    }
}