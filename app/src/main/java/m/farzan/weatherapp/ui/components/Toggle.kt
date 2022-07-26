package m.farzan.weatherapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Toggle(
    modifier: Modifier = Modifier,
    texes: List<String>,
    items: @Composable (index: Int, text: String) -> Unit
) {

    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        for (i in texes.indices) {
            items(i, texes[i])
        }
    }
}


