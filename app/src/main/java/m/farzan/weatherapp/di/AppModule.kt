package m.farzan.weatherapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import m.farzan.weatherapp.data.CitiesDatabase
import m.farzan.weatherapp.data.DatabaseDao
import m.farzan.weatherapp.network.Api
import m.farzan.weatherapp.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): Api {
        return Retrofit.Builder()
            .baseUrl(Constants.WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideTasksDao(citiesDatabase: CitiesDatabase): DatabaseDao = citiesDatabase.citiesDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): CitiesDatabase {
        return Room.databaseBuilder(context, CitiesDatabase::class.java, "cities_db")
            .fallbackToDestructiveMigration().build()
    }


}