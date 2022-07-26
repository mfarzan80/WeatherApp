package m.farzan.weatherapp.util

import m.farzan.weatherapp.model.WeatherItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Comparator
import kotlin.collections.HashMap

val apiDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")


fun String.firstUppercase(): String {
    return this.substring(0, 1).uppercase() + this.substring(1)
}

fun dateToWeatherItem(weatherItems: List<WeatherItem>): Map<LocalDate, ArrayList<WeatherItem>> {
    val map = HashMap<LocalDate, ArrayList<WeatherItem>>()
    weatherItems.forEach {
        val localDate = LocalDate.from(apiDateFormatter.parse(it.dt_txt))
        var arrayList: ArrayList<WeatherItem>? = map[localDate]
        if (arrayList == null) {
            arrayList = ArrayList()
            map[localDate] = arrayList
        }
        arrayList.add(it)
    }

    return map
}