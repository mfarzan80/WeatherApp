package m.farzan.weatherapp.ui.main

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import m.farzan.weatherapp.data.DataOrException
import m.farzan.weatherapp.model.City
import m.farzan.weatherapp.model.Coord
import m.farzan.weatherapp.model.CurrentWeather
import m.farzan.weatherapp.model.NextDaysWeather
import m.farzan.weatherapp.repository.RecentCitiesRepository
import m.farzan.weatherapp.repository.WeatherRepository
import m.farzan.weatherapp.util.SharedPrefManager
import m.farzan.weatherapp.util.SharedPrefManager.CITY_PRIMARY_KEY
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val recentCitiesRepository: RecentCitiesRepository
) : ViewModel() {

    val nextDaysData: MutableState<DataOrException<NextDaysWeather, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, null))

    val currentData: MutableState<DataOrException<CurrentWeather, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, null))

    companion object {
        var units = "metric"
    }


    private val _recentCities = MutableStateFlow<List<City>>(emptyList())
    val recentCities = _recentCities.asStateFlow()

    init {
        loadCitiesList()
    }


    fun loadWeather(context: Context): Boolean {
        val city = getSelectedCity(context)
        if (city != null) {
            getCurrentWeather(city)
            getNextDaysWeather(city)


            return true
        }
        return false
    }

    private fun getNextDaysWeather(city: City) {
        viewModelScope.launch {
            nextDaysData.value.loading = true
            nextDaysData.value = weatherRepository.getNextDaysWeather(city.coord)
            Log.d("WeatherData", "getWeather: " + nextDaysData.value.data)
            if (nextDaysData.value.data.toString().isNotEmpty()) {
                nextDaysData.value.loading = false
                if (city.name == null) {
                    val fulCity = nextDaysData.value.data!!.city
                    recentCitiesRepository.update(
                        city.update(
                            name = fulCity.name,
                            country = fulCity.country
                        )
                    )
                    Log.d("WeatherData", "getNextDaysWeather: city.name == null")
                }
            }
        }
    }

    private fun getCurrentWeather(city: City) {
        viewModelScope.launch {
            currentData.value.loading = true
            currentData.value = weatherRepository.getCurrentWeather(city.coord)
            Log.d("WeatherData", "getWeather: " + currentData.value.data)
            if (currentData.value.data.toString().isNotEmpty())
                currentData.value.loading = false
        }
    }


    fun getSelectedCity(context: Context): City? {
        var city: City? = null
        runBlocking {
            val cityID = SharedPrefManager(context).getString(CITY_PRIMARY_KEY)
            if (cityID != null) {
                city = recentCitiesRepository.getCityById(cityID)
            }

        }

        return city
    }

    private fun loadCitiesList() {
        viewModelScope.launch(Dispatchers.IO) {
            recentCitiesRepository.getAll().distinctUntilChanged()
                .collect { listOfTasks ->
                    _recentCities.value = listOfTasks
                }
        }
    }

    fun updateSelectedCityAndReload(context: Context, city: City) {
        setSelectedCity(context, city)
        loadWeather(context)
    }

    private fun setSelectedCity(context: Context, city: City) {
        SharedPrefManager(context).putString(CITY_PRIMARY_KEY, city.key)
    }

    fun setSelectedAndAddToRecent(context: Context, city: City) {
        runBlocking {
            recentCitiesRepository.add(city)
            setSelectedCity(context, city)
        }
    }

    fun updateRecentCity(city: City) {
        viewModelScope.launch {
            recentCitiesRepository.update(city)
        }

    }


    fun removeFromRecent(context: Context, city: City): Boolean {
        var isSelectedCityRemoved = false
        runBlocking {
            val key = getSelectedCity(context)!!.key
            recentCitiesRepository.remove(city)
            if (key == city.key) {
                setSelectedCity(context, recentCities.value[0])
                isSelectedCityRemoved = true
            }
        }
        return isSelectedCityRemoved
    }


}