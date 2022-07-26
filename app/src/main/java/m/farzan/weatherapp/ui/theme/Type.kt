package m.farzan.weatherapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import m.farzan.weatherapp.R

val sansPro = FontFamily(
    Font(
        resId = R.font.sans_pro_black,
        weight = FontWeight.Black
    ),
    Font(
        resId = R.font.sans_pro_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.sans_pro_sami_bold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.sans_pro_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.sans_pro_light,
        weight = FontWeight.Light
    ),
    Font(
        resId = R.font.sans_pro_extra_light,
        weight = FontWeight.ExtraLight
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.Black,
        fontSize = 40.sp
    ),
    h2 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.Black,
        fontSize = 36.sp
    ),
    h3 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.Bold,
        fontSize = 33.sp
    ),
    h4 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    ),
    h6 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    button = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    body2 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = sansPro,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp
    )

)