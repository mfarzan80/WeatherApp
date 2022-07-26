package m.farzan.weatherapp.network


import m.farzan.weatherapp.model.CurrentWeather
import m.farzan.weatherapp.model.NextDaysWeather
import m.farzan.weatherapp.model.citySearch.CityList
import m.farzan.weatherapp.ui.main.MainViewModel
import m.farzan.weatherapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface Api {

    //?lat={lat}&lon={lon}&appid={API key}

    @GET("data/2.5/forecast")
    suspend fun getNextDaysWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String = Constants.WEATHER_API_KEY,
        @Query("units") units: String = MainViewModel.units
    ): NextDaysWeather


    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String = Constants.WEATHER_API_KEY,
        @Query("units") units: String = MainViewModel.units
    ): CurrentWeather

    @GET("geo/1.0/direct")
    suspend fun searchCity(
        @Query("q") name: String,
        @Query("limit") limit: Int = 10,
        @Query("appid") apiKey: String = Constants.WEATHER_API_KEY,
    ): CityList

    //http://api.openweathermap.org/geo/1.0/reverse?lat=32.2978929&lon=54.0116401&appid=d271c41d98df331a39a946458cc0d2e5

    @GET("geo/1.0/reverse")
    suspend fun getCityByCoord(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("limit") limit: Int = 10,
        @Query("appid") apiKey: String = Constants.WEATHER_API_KEY,
    ): CityList
}