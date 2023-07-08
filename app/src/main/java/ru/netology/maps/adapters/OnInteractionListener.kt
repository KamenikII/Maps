package ru.netology.maps.adapters

import ru.netology.maps.dataclass.PointMap

interface OnInteractionListener {
    fun onEdit(pointMap: PointMap) {}
    fun onRemove(pointMap: PointMap) {}
    fun onMove(pointMap: PointMap) {}
}