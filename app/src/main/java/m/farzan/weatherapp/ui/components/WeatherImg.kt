package m.farzan.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import m.farzan.weatherapp.R

/*
500 	Rain 	light rain 	10d
501 	Rain 	moderate rain 	10d
502 	Rain 	heavy intensity rain 	10d
503 	Rain 	very heavy rain 	10d
504 	Rain 	extreme rain 	10d
511 	Rain 	freezing rain 	13d
520 	Rain 	light intensity shower rain 	09d
521 	Rain 	shower rain 	09d
522 	Rain 	heavy intensity shower rain 	09d
531
 */

val idToDrawableId = mapOf(
    2 to R.drawable.thunderstorm,
    300 to R.drawable.light_rain,
    301 to R.drawable.light_rain,
    302 to R.drawable.heavy_rain,
    310 to R.drawable.light_rain,
    311 to R.drawable.light_rain,
    312 to R.drawable.heavy_rain,
    313 to R.drawable.heavy_rain,
    314 to R.drawable.heavy_rain,
    321 to R.drawable.heavy_rain,
    500 to R.drawable.light_rain,
    501 to R.drawable.light_rain,
    502 to R.drawable.heavy_rain,
    503 to R.drawable.heavy_rain,
    504 to R.drawable.heavy_rain,
    511 to R.drawable.heavy_rain,
    520 to R.drawable.heavy_rain,
    521 to R.drawable.heavy_rain,
    522 to R.drawable.heavy_rain,
    531 to R.drawable.heavy_rain,
    6 to R.drawable.snow,
    7 to R.drawable.clear,
    800 to R.drawable.clear,
    801 to R.drawable.almost_cloud,
    802 to R.drawable.cloudy,
    803 to R.drawable.cloudy,
    804 to R.drawable.cloudy,
)

@Composable
fun WeatherImage(modifier: Modifier, imgId: Int , contentScale: ContentScale) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(
                id = idToDrawableId[
                        when (imgId / 100) {
                            2, 6, 7 -> imgId / 100
                            else -> imgId
                        }
                ]!!
            ),
            contentDescription = "status img",
            contentScale = contentScale
        )
    }
}