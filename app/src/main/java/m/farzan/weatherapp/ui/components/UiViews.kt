package m.farzan.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ErrorView(
    message: String,
    color: Color = MaterialTheme.colors.onBackground,
    onTryAgain: () -> Unit = {}
) {
    Text(
        text = message,
        style = MaterialTheme.typography.body1,
        color = color
    )
    if (onTryAgain != {}) {
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = onTryAgain) {
            Text(text = "Try again", style = MaterialTheme.typography.button)
        }
    }

}

@Composable
fun LoadingView() {

    CircularProgressIndicator(modifier = Modifier.padding(vertical = 40.dp))

}