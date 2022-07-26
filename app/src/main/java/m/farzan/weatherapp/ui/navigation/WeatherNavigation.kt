package m.farzan.weatherapp.ui.navigation


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import m.farzan.weatherapp.ui.main.MainScreen
import m.farzan.weatherapp.ui.main.MainViewModel
import m.farzan.weatherapp.ui.screens.SplashScreen
import m.farzan.weatherapp.ui.search.SearchScreen
import m.farzan.weatherapp.ui.search.SearchViewModel

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    val mainViewModel = hiltViewModel<MainViewModel>()
    val searchViewModel = hiltViewModel<SearchViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.name
    ) { //todo splash


        composable(route = Screens.SplashScreen.name) {
            SplashScreen(navController)
        }

        composable(route = Screens.MainScreen.name) {
            MainScreen(navController, mainViewModel)
        }

        composable(route = Screens.SearchScreen.name) {
            SearchScreen(
                navController = navController,
                searchViewModel = searchViewModel,
                mainViewModel = mainViewModel
            )
        }


    }
}