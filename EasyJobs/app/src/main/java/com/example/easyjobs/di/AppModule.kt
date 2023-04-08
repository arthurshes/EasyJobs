package com.example.easyjobs.di

import android.app.Application
import androidx.room.Room
import com.example.easyjobs.db.MainDb
import com.example.easyjobs.network.ApiService
import com.example.easyjobs.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    ///
    @Provides
    @Singleton
    fun provideRetrofit():ApiService=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provide())
            // .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    @Provides
    @Singleton
    fun provide():OkHttpClient{
        val interceptor= HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY

      return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideMainDb(app:Application):MainDb =
        Room.databaseBuilder(app,MainDb::class.java,"db.test")
            .fallbackToDestructiveMigration()
            .build()
}