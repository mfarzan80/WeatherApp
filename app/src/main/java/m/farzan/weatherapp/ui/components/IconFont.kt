package m.farzan.weatherapp.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import m.farzan.weatherapp.R

@Composable
fun IconFont(
    modifier: Modifier = Modifier,
    unicode: String,
    size: TextUnit,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onBackground
) {
    Text(
        modifier = modifier,
        text = unicode,
        fontFamily = FontFamily(Font(resId = R.font.font_awesome)),
        fontSize = size,
        textAlign = textAlign,
        color = color
    )
}