package m.farzan.weatherapp.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AutoSizeText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    maxLines: Int = 10,
    textAlign: TextAlign = TextAlign.Start
) {
    val scaledTextStyle = remember { mutableStateOf(style) }
    val readyToDraw = remember { mutableStateOf(false) }

    Text(
        text,
        modifier.drawWithContent {
            if (readyToDraw.value) {
                drawContent()
            }
        },
        maxLines = maxLines,
        style = scaledTextStyle.value,
        textAlign = textAlign,
        softWrap = false,
        onTextLayout = fun(textLayoutResult: TextLayoutResult) {
            if (textLayoutResult.didOverflowHeight) {
                scaledTextStyle.value =
                    scaledTextStyle.value.copy(fontSize = scaledTextStyle.value.fontSize * 0.9)
            } else {
                readyToDraw.value = true
            }

        }
    )
}