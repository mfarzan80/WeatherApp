package m.farzan.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

private const val FLAG_API_END_POINT = "https://countryflagsapi.com/png/"

@Composable
fun FlagImage(modifier: Modifier = Modifier, country: String) {
    Image(
        modifier = modifier,
        painter = rememberAsyncImagePainter(FLAG_API_END_POINT + country),
        contentDescription = "flag",
        contentScale = ContentScale.Crop
    )
}