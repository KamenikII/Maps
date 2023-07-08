package ru.netology.maps.adapters

import androidx.recyclerview.widget.RecyclerView
import ru.netology.maps.databinding.PointCardBinding
import ru.netology.maps.dataclass.PointMap

class PointViewHolder(
    private val binding: PointCardBinding,
    private val onInteractionListener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {

    fun renderingPostStructure(pointMap: PointMap) {
        with(binding) {
            descriptionPoint.text = pointMap.description
            titlePoint.text = pointMap.title
            val coordinatePoint = "${pointMap.latitude}; ${pointMap.longitude}"
            coordinate.text = coordinatePoint
            postListeners(pointMap)
        }
    }

    private fun postListeners(pointMap: PointMap) {
        with(binding) {
            point.setOnClickListener {
                onInteractionListener.onMove(pointMap)
            }
            remove.setOnLongClickListener {
                onInteractionListener.onRemove(pointMap)
                true
            }
            edit.setOnLongClickListener {
                onInteractionListener.onEdit(pointMap)
                true
            }
        }
    }
}