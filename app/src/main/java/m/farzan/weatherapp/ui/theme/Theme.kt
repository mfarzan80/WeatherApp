package m.farzan.weatherapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White

private val DarkColorPalette = darkColors(
    primary = Blue1,
    primaryVariant = Blue2,
    secondary = Blue1,
    background = Dark2,
    surface = Dark2,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
)

private val LightColorPalette = lightColors(
    primary = Blue1,
    primaryVariant = Blue2,
    secondary = Blue1,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = White,
    onBackground = Dark2,
    onSurface = Dark2,
)


@get:Composable
val Colors.onBackgroundAlpha: Color
    get() = onBackground.copy(.75f)


@Composable
fun WeatherAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}