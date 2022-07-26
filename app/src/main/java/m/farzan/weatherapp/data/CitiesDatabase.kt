package m.farzan.weatherapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import m.farzan.weatherapp.model.City
import m.farzan.weatherapp.util.CoordConverter

@Database(entities = [City::class], version = 1)
@TypeConverters(CoordConverter::class)
abstract class CitiesDatabase : RoomDatabase() {
    abstract fun citiesDao(): DatabaseDao
}
