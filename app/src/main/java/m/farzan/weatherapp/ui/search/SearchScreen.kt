package m.farzan.weatherapp.ui.search


import android.Manifest
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.ContextWrapper
import android.content.IntentSender
import android.content.IntentSender.SendIntentException
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavController
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.delay
import m.farzan.weatherapp.MainActivity
import m.farzan.weatherapp.R
import m.farzan.weatherapp.model.City
import m.farzan.weatherapp.model.Coord
import m.farzan.weatherapp.model.citySearch.CityListItem
import m.farzan.weatherapp.ui.components.*
import m.farzan.weatherapp.ui.main.MainViewModel
import m.farzan.weatherapp.ui.theme.WeatherAppTheme
import m.farzan.weatherapp.ui.theme.onBackgroundAlpha

private lateinit var fusedLocationClient: FusedLocationProviderClient

@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel, mainViewModel: MainViewModel
) {
    val context = LocalContext.current
    val cityName = remember {
        mutableStateOf("")
    }

    fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.padding(start = 10.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (mainViewModel.recentCities.value.isNotEmpty())
                IconButton(onClick = { navController.popBackStack() }) {
                    IconFont(unicode = "\uf104", size = 22.sp, textAlign = TextAlign.Center)
                }

            OutlinedInput(
                valueState = cityName,
                onValueChange = {
                    cityName.value = it
                },
                textStyle = MaterialTheme.typography.body1.copy(
                    color =
                    MaterialTheme.colors.onBackground
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                label =
                "City", leadingIcon = {
                    IconFont(unicode = "\uf002", size = 17.sp, textAlign = TextAlign.Center)
                })
        }

        Spacer(modifier = Modifier.height(20.dp))


        LaunchedEffect(key1 = cityName.value) {
            delay(100)
            if (cityName.value.isNotEmpty())
                searchViewModel.searchCityByName(cityName.value)
        }


        if (cityName.value.isEmpty()) {
            UseCurrentLocation(context = context, onFindLocation = { coord ->
                if (coord != null) {
                    searchViewModel.searchCityByCoord(coord)
                    val newCity = City(coord, null, null)
                    mainViewModel.setSelectedAndAddToRecent(context, newCity)
                    navController.popBackStack()
                } else {
                    Toast.makeText(
                        context,
                        "Failed to found location",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            )
        } else {
            if (searchViewModel.foundedCity.value.loading == true)
                CircularProgressIndicator()
            else if (searchViewModel.foundedCity.value.e != null)
                ErrorView(message = stringResource(id = R.string.connectionError)) {
                    searchViewModel.searchCityByName(cityName.value)
                }
            else if (searchViewModel.foundedCity.value.data.isNullOrEmpty())
                ErrorView(message = "City not found")
            else
                CitiesColumn(
                    cities = searchViewModel.foundedCity.value.data!!
                ) {
                    val newCity = City(Coord(it.lat, it.lon), it.country, it.name)
                    mainViewModel.setSelectedAndAddToRecent(context, newCity)
                    navController.popBackStack()
                }
        }

    }
}

@Composable
fun UseCurrentLocation(context: Context, onFindLocation: (coord: Coord?) -> Unit) {

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            getLocation { onFindLocation(it) }
        } else {

            Log.d("ExampleScreen", "PERMISSION DENIED")
        }
    }

    Text(
        text = "Enter the name of your city",
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.body2
    )
    Text(
        modifier = Modifier.padding(vertical = 10.dp),
        text = "Or",
        color = MaterialTheme.colors.onBackgroundAlpha,
        style = MaterialTheme.typography.subtitle1
    )
    Button(onClick = {
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) -> {
                getLocation { onFindLocation(it) }
            }
            else -> {
                launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }

    }) {
        Text(text = "Use my location")
    }
}

fun getLocation(callback: (coord: Coord?) -> Unit) {
    fusedLocationClient.lastLocation
        .addOnSuccessListener { location: Location? ->
            if (location == null)
                callback(null)
            else
                callback(Coord(lat = location.latitude, lon = location.longitude))
        }
}

@Composable
fun CitiesColumn(cities: List<CityListItem>, onSelectCity: (cityListItem: CityListItem) -> Unit) {
    LazyColumn {
        items(items = cities) { cityItem ->

            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onSelectCity(cityItem)
                        }
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ShimmerImage(
                        modifier = Modifier
                            .size(40.dp)
                            .border(
                                width = .5.dp,
                                color = MaterialTheme.colors.onBackground.copy(.15f),
                                CircleShape
                            )
                            .clip(shape = CircleShape)
                    ) {
                        FlagImage(
                            modifier = Modifier.fillMaxSize(), country = cityItem.country
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Text(
                            text = cityItem.name,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onBackground
                        )
                        if (cityItem.state != null) {
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = cityItem.state,
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.onBackgroundAlpha
                            )
                        }

                    }
                }

                Divider(
                    color = MaterialTheme.colors.onBackground.copy(.1f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp)
                        .padding(start = 50.dp)
                )

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityPreview() {
    WeatherAppTheme {
        CitiesColumn(
            listOf(
                CityListItem("IR", 53.0, 54.0, "Ardakan", "Yazd"),
                CityListItem("IR", 53.0, 54.0, "Ardakan", "Yazd"),
                CityListItem("IR", 53.0, 54.0, "Ardakan", "Yazd"),
            )
        ) {}
    }
}
