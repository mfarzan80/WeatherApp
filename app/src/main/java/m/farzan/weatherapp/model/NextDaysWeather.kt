package m.farzan.weatherapp.model

data class NextDaysWeather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherItem>,
    val message: Int
)