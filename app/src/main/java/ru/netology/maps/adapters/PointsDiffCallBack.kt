package ru.netology.maps.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.netology.maps.dataclass.PointMap

class PointsDiffCallback : DiffUtil.ItemCallback<PointMap>() {
    override fun areItemsTheSame(oldItem: PointMap, newItem: PointMap): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PointMap, newItem: PointMap): Boolean {
        return oldItem == newItem
    }
}