package m.farzan.weatherapp.ui.search

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import m.farzan.weatherapp.data.DataOrException
import m.farzan.weatherapp.model.City
import m.farzan.weatherapp.model.Coord
import m.farzan.weatherapp.model.citySearch.CityList
import m.farzan.weatherapp.repository.CitiesRepository
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: CitiesRepository) :
    ViewModel() {



    val foundedCity: MutableState<DataOrException<CityList, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, null))


    fun searchCityByName(name: String) {
        viewModelScope.launch {
            foundedCity.value.loading = true
            foundedCity.value = repository.searchCity(name)
            foundedCity.value.loading = false
        }
    }


    fun searchCityByCoord(coord: Coord) {
        viewModelScope.launch {
            foundedCity.value.loading = true
            foundedCity.value = repository.getCityByCoord(coord)
            foundedCity.value.loading = false
        }
    }



}