package m.farzan.weatherapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "recent_cities")
data class City(
    val coord: Coord,
    var country: String?,
    var name: String?,

    ) {

    @PrimaryKey(autoGenerate = false)
    var key: String = UUID.randomUUID().toString()

    fun update(country: String?, name: String?): City {
        this.name = name
        this.country = country
        return this
    }

}