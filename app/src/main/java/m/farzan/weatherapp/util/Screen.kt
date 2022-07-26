package m.farzan.weatherapp.util

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getScreenSize(height: Boolean): Dp {
    val configuration = LocalConfiguration.current
    return if (height)
        configuration.screenHeightDp.dp
    else
        configuration.screenWidthDp.dp
}