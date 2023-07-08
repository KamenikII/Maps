package ru.netology.maps.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.netology.maps.dao.PointDao
import ru.netology.maps.dao.PointMapEntity
import ru.netology.maps.dao.toDto
import ru.netology.maps.dataclass.PointMap
import javax.inject.Inject

class PointRepositoryImpl @Inject constructor(
    private val dao: PointDao,
) : PointRepository {
    override val data: Flow<List<PointMap>>
        get() = dao.getAll()
            .map(List<PointMapEntity>::toDto)
            .flowOn(Dispatchers.Default)

    override suspend fun edit(pointMap: PointMap) {

    }

    override suspend fun removeById(id: Int) {
        dao.removeById(id)
    }

    override suspend fun save(pointMap: PointMap) {
        dao.insert(PointMapEntity.fromDto(pointMap))
    }
}