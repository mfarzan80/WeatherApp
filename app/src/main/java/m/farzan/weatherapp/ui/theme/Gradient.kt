package m.farzan.weatherapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

@Composable
fun Colors.mainGradient(): Brush {
    val startOffset = Offset(0f, Float.POSITIVE_INFINITY)
    val endOffset = Offset(Float.POSITIVE_INFINITY, 0f)
    return if (isLight)
        Brush.linearGradient(
            colors = listOf(
                Blue2, Blue1
            ),
            start = startOffset, end = endOffset
        ) else
        Brush.linearGradient(
            colors = listOf(
                Dark1, DarkBlue1
            ),
            start = startOffset, end = endOffset
        )

}
