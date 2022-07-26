package m.farzan.weatherapp.model.citySearch

data class CityListItem(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String?
)