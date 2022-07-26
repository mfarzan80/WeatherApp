package m.farzan.weatherapp.data

import android.provider.SyncStateContract.Helpers.insert
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import m.farzan.weatherapp.model.City
import m.farzan.weatherapp.model.citySearch.CityList


@Dao
interface DatabaseDao {
    @Query("SELECT * FROM recent_cities")
    fun getAllCities(): Flow<List<City>>

    @Query("SELECT * FROM recent_cities WHERE `key` == :id")
    suspend fun getCityById(id: String): City

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: City)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCity(city: City)

    @Delete
    suspend fun deleteCity(city: City)

}