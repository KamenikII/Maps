package ru.netology.maps.repository

import kotlinx.coroutines.flow.Flow
import ru.netology.maps.dataclass.PointMap

interface PointRepository {
    val data: Flow<List<PointMap>>
    suspend fun edit(pointMap: PointMap)
    suspend fun removeById(id: Int)
    suspend fun save(pointMap: PointMap)
}