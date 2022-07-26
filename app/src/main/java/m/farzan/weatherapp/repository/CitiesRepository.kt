package m.farzan.weatherapp.repository

import android.util.Log
import m.farzan.weatherapp.data.DataOrException
import m.farzan.weatherapp.model.Coord
import m.farzan.weatherapp.model.citySearch.CityList
import m.farzan.weatherapp.network.Api
import javax.inject.Inject


class CitiesRepository @Inject constructor(private val api: Api) {


    suspend fun searchCity(name: String): DataOrException<CityList, Boolean, Exception> {
        val response = try {

            api.searchCity(name)
        } catch (e: Exception) {
            Log.e("CitiesRepository", "searchCity: ", e)
            return DataOrException(e = e)
        }
        Log.d("CitiesRepository", "searchCity Response : $response")
        return DataOrException(data = response)
    }

    suspend fun getCityByCoord(coord: Coord): DataOrException<CityList, Boolean, Exception> {
        val response = try {
            api.getCityByCoord(coord.lat, coord.lon)
        } catch (e: Exception) {
            Log.e("CitiesRepository", "getCityByCoord: ", e)
            return DataOrException(e = e)
        }
        Log.d("CitiesRepository", "getCityByCoord Response : $response")
        return DataOrException(data = response)
    }
}
