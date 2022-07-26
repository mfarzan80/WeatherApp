package m.farzan.weatherapp.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import m.farzan.weatherapp.data.DatabaseDao
import m.farzan.weatherapp.model.City
import javax.inject.Inject

class RecentCitiesRepository @Inject constructor(private val databaseDao: DatabaseDao) {

    suspend fun add(city: City) {
        databaseDao.insertCity(city)
    }

    suspend fun update(city: City) {
        databaseDao.updateCity(city)
    }

    suspend fun remove(city: City) {
        databaseDao.deleteCity(city)
    }

    suspend fun getCityById(key: String): City{
        return databaseDao.getCityById(key)
    }

    fun getAll(): Flow<List<City>> {
        return databaseDao.getAllCities().flowOn(
            Dispatchers.IO
        ).conflate()
    }
}