package m.farzan.weatherapp.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerImage(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(0.dp),
    elevation: Dp = 0.dp,
    image: @Composable () -> Unit

) {

    Card(modifier = modifier, shape = shape, elevation = elevation) {
        Box(
            modifier = Modifier
                .shimmer()
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.LightGray)
                .zIndex(-1f)
        )
        image()

    }

}