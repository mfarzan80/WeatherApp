package m.farzan.weatherapp.repository

import android.util.Log
import m.farzan.weatherapp.data.DataOrException
import m.farzan.weatherapp.model.Coord
import m.farzan.weatherapp.model.CurrentWeather
import m.farzan.weatherapp.model.NextDaysWeather
import m.farzan.weatherapp.network.Api
import javax.inject.Inject


class WeatherRepository @Inject constructor(private val api: Api) {

    suspend fun getNextDaysWeather(coord: Coord): DataOrException<NextDaysWeather, Boolean, Exception> {
        val response = try {
            api.getNextDaysWeather(lat = coord.lat, lon = coord.lon)
        } catch (e: Exception) {
            Log.e("WeatherException", "getWeather: ", e)
            return DataOrException(e = e)
        }

        return DataOrException(data = response)
    }

    suspend fun getCurrentWeather(coord: Coord): DataOrException<CurrentWeather, Boolean, Exception> {
        val response = try {
            api.getCurrentWeather(lat = coord.lat, lon = coord.lon)
        } catch (e: Exception) {
            Log.e("WeatherException", "getCurrentWeather: ", e)
            return DataOrException(e = e)
        }

        return DataOrException(data = response)
    }


}