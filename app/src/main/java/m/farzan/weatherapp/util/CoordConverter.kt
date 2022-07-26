package m.farzan.weatherapp.util

import androidx.room.TypeConverter
import m.farzan.weatherapp.model.Coord

class CoordConverter {
    companion object {
        const val SEPARATOR = ":"
    }

    @TypeConverter
    fun coordToString(coord: Coord): String {
        return "${coord.lat}$SEPARATOR${coord.lon}"
    }

    @TypeConverter
    fun stringToCoord(string: String): Coord {
        val coordArr = string.split(SEPARATOR)
        return Coord(coordArr[0].toDouble(), coordArr[1].toDouble())
    }
}