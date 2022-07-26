package m.farzan.weatherapp.ui.main

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import m.farzan.weatherapp.R
import m.farzan.weatherapp.ui.components.*
import m.farzan.weatherapp.model.WeatherItem
import m.farzan.weatherapp.ui.navigation.Screens
import m.farzan.weatherapp.ui.theme.mainGradient
import m.farzan.weatherapp.ui.theme.onBackgroundAlpha
import m.farzan.weatherapp.util.apiDateFormatter
import m.farzan.weatherapp.util.dateToWeatherItem
import m.farzan.weatherapp.util.firstUppercase
import m.farzan.weatherapp.util.getScreenSize
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

val displayDateFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM")

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {
    Log.d("SearchScreen", "MainScreen: ")
    val context = LocalContext.current
    val haveCity = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = true) {
        if (mainViewModel.loadWeather(context)) {
            haveCity.value = 2
        } else {
            haveCity.value = 1
            navController.navigate(route = Screens.SearchScreen.name)
        }

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (haveCity.value == 2) {
            if (mainViewModel.currentData.value.loading == true)
                LoadingView()
            else if (mainViewModel.currentData.value.e != null)
                ErrorView(message = stringResource(id = R.string.connectionError)) {
                    mainViewModel.loadWeather(
                        context
                    )
                }
            else
                TopView(navController, mainViewModel)
        }
    }

}


@Composable
fun TopView(navController: NavController, mainViewModel: MainViewModel) {
    val context = LocalContext.current
    val currentData = mainViewModel.currentData.value.data!!

    val screenHeight = getScreenSize(height = true)


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(rememberScrollState())
    ) {
        val cityRow = createRef()
        val img = createRef()
        val temp = createRef()
        val status = createRef()
        val bottomCard = createRef()

        Spacer(
            modifier = Modifier
                .background(
                    brush = MaterialTheme.colors.mainGradient()
                )
                .fillMaxWidth()
                .height(screenHeight * 0.7f)
                .constrainAs(createRef()) {
                    top.linkTo(parent.top)
                })

        HeaderRow(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(start = 25.dp, end = 5.dp)
                .constrainAs(cityRow) { top.linkTo(parent.top, 5.dp) },
            navController = navController,
            mainViewModel = mainViewModel
        ) {
            mainViewModel.loadWeather(context)
        }

        WeatherImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.21f)
                .constrainAs(img) {
                    top.linkTo(cityRow.bottom)
                }, currentData.weather[0].id, ContentScale.FillHeight
        )

        TempRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.2f)
                .constrainAs(temp) {
                    top.linkTo(img.bottom)
                },
            currentData.main.temp.toInt().toString(),
            currentData.main.feels_like.toInt().toString()
        ) {
            MainViewModel.units = if (it) "metric" else "imperial"
            mainViewModel.loadWeather(context)
        }

        WeatherStatus(
            modifier = Modifier
                .constrainAs(status) {
                    top.linkTo(temp.bottom, (-10).dp)
                },
            currentData.weather[0].description.firstUppercase(),
            "${currentData.wind.speed} km/h",
            "${currentData.main.humidity} %"
        )

        BottomView(
            modifier = Modifier
                .constrainAs(bottomCard) {
                    top.linkTo(status.bottom, 20.dp)
                }, mainViewModel
        )

    }

}

@Composable
fun BottomView(modifier: Modifier, mainViewModel: MainViewModel) {
    val context = LocalContext.current
    Card(
        modifier = modifier,
        elevation = 0.dp, shape = RoundedCornerShape(
            topStartPercent = 10, topEndPercent = 10
        )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (mainViewModel.nextDaysData.value.loading == true)
                LoadingView()
            else if (mainViewModel.nextDaysData.value.e != null)
                ErrorView(message = stringResource(id = R.string.connectionError)) {
                    mainViewModel.loadWeather(
                        context
                    )
                }
            else
                BottomCard(mainViewModel.nextDaysData.value.data!!.list)
        }
    }

}

@Composable
fun BottomCard(weatherItems: List<WeatherItem>) {

    val date = remember { mutableStateOf(LocalDate.now()) }

    val dateToWeather = dateToWeatherItem(weatherItems)



    DaysRow(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
        ArrayList(dateToWeather.keys)
    ) { selectedDate ->
        date.value = selectedDate
    }

    Spacer(modifier = Modifier.height(25.dp))

    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        items(items = dateToWeather[date.value]!!) {
            NextTimeWeather(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                time = LocalTime.from(apiDateFormatter.parse(it.dt_txt))
                    .format(timeFormatter),
                temp = it.main.temp.toInt().toString() + "°",
                vectorId = it.weather[0].id
            )
        }

    }

}


@Composable
fun NextTimeWeather(modifier: Modifier = Modifier, time: String, temp: String, vectorId: Int) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherImage(
            modifier = Modifier.size(70.dp),
            vectorId, ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.heightIn(5.dp))
        Text(
            text = time, style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackgroundAlpha
        )
        Text(
            text = temp, style = MaterialTheme.typography.body2.copy(fontSize = 28.sp),
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
fun WeatherStatus(
    modifier: Modifier,
    description: String,
    windSpeed: String,
    humidity: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = description, style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onPrimary
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            StatusColumn(
                modifier = Modifier.weight(1f),
                value = windSpeed,
                unicode = "\uf72e",
                label = "wind"
            )
            StatusColumn(
                modifier = Modifier.weight(1f),
                value = humidity,
                unicode = "\uf043",
                label = "humidity"
            )
        }
    }
}

@Composable
fun TempRow(
    modifier: Modifier,
    temp: String,
    feelsLike: String,
    onToggle: (metric: Boolean) -> Unit
) {
    val unitsToggle = remember {
        mutableStateOf(0)
    }
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.Center
    ) {

        AutoSizeText(
            modifier = Modifier
                .fillMaxHeight()
                .padding(0.dp),
            text = temp,
            style = TextStyle(
                fontSize = 140.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colors.onPrimary
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Toggle(
                texes = listOf("°C", "°F"),
            ) { index, text ->
                Text(modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        if (index != unitsToggle.value) {
                            unitsToggle.value = index
                            onToggle(index == 0)
                        }
                    }
                    .padding(end = 15.dp), text = text,
                    color = if (index != unitsToggle.value) MaterialTheme.colors.onPrimary.copy(
                        alpha = .6f
                    )
                    else
                        MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.h5
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Feels like",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                text = "$feelsLike°",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Composable
fun HeaderRow(
    modifier: Modifier,
    mainViewModel: MainViewModel,
    navController: NavController,
    onReload: () -> Unit
) {
    val context = LocalContext.current
    val citiesNameList = ArrayList<String>()
    val cities = mainViewModel.recentCities.collectAsState().value
    val selectedIndex = remember {
        mutableStateOf(cities.indexOf(mainViewModel.getSelectedCity(context)))
    }


    cities.forEach {
        citiesNameList.add(it.name ?: "Unknown")
    }

    val selectedCity = citiesNameList[selectedIndex.value]

    citiesNameList.add("Add another city")
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {


        IconFont(//location
            unicode = "\uf3c5",
            size = 18.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onPrimary
        )

        Spacer(modifier = Modifier.width(5.dp))

        Spinner(items = citiesNameList,
            dropDownIconColor = MaterialTheme.colors.onPrimary,
            selectedItemTextColor = MaterialTheme.colors.onPrimary,
            itemsTextColor = MaterialTheme.colors.onBackground,
            text = selectedCity,
            menuItem = { index, item ->
                Row(
                    modifier = Modifier.width(170.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground
                    )

                    if (index < citiesNameList.size - 1) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {

                            IconButton(onClick = {
                                if (citiesNameList.size > 2) {
                                    if (mainViewModel.removeFromRecent(
                                            context,
                                            cities[index]
                                        )
                                    ) {
                                        mainViewModel.loadWeather(context)
                                        selectedIndex.value = 0

                                    }
                                } else
                                    Toast.makeText(
                                        context,
                                        "You can't delete the only remaining city",
                                        Toast.LENGTH_LONG
                                    ).show()
                            }) {
                                IconFont(

                                    unicode = "\uf2ed",
                                    size = 18.sp,
                                    textAlign = TextAlign.End,
                                    color = MaterialTheme.colors.onBackgroundAlpha
                                )
                            }


                        }
                    }
                }
            },
            onItemChange = { index, item ->
                if (index < cities.size) {
                    selectedIndex.value = index
                    mainViewModel.updateSelectedCityAndReload(context = context, cities[index])
                } else
                    navController.navigate(route = Screens.SearchScreen.name)
            })

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            IconButton(onClick = onReload) { //reload
                IconFont(
                    unicode = "\uf021", size = 22.sp,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}


@Composable
fun StatusColumn(modifier: Modifier = Modifier, value: String, unicode: String, label: String) {

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onPrimary
        )
        IconFont(
            modifier = Modifier
                .padding(vertical = 5.dp),
            unicode = unicode,
            size = 15.sp, color = MaterialTheme.colors.onPrimary
        )
        Text(
            text = label, style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onPrimary.copy(alpha = .8f)
        )
    }
}

@Composable
fun DaysRow(modifier: Modifier, dates: List<LocalDate>, onDateChange: (date: LocalDate) -> Unit) {
    val datesToggle = remember {
        mutableStateOf(0)
    }

    val reversedDates = dates.reversed()

    val displayDates = ArrayList<String>()
    reversedDates.forEach {
        displayDates.add(it.format(displayDateFormatter))
    }

    Toggle(
        modifier = modifier,
        texes = displayDates
    ) { index, text ->
        val active = index == datesToggle.value
        val buttonModifier = Modifier
            .defaultMinSize(minWidth = getScreenSize(height = false) * 30 / 100)
            .padding(horizontal = 7.dp)

        val onClick = {
            datesToggle.value = index
            onDateChange(reversedDates[index])
        }

        if (active) {
            Button(
                modifier = buttonModifier,
                onClick = onClick,
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = text,
                    maxLines = 1,
                    style = MaterialTheme.typography.button.copy(fontSize = 16.sp),
                    color = if (active) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackgroundAlpha
                )
            }
        } else {
            OutlinedButton(
                modifier = buttonModifier,
                onClick = onClick,
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = text,
                    maxLines = 1,
                    style = MaterialTheme.typography.button.copy(fontSize = 16.sp),
                    color = if (active) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackgroundAlpha
                )
            }
        }


    }
}
