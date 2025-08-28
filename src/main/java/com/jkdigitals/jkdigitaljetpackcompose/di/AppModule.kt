package com.jkdigitals.jkdigitaljetpackcompose.di

import com.google.gson.Gson
import com.jkdigitals.jkdigitaljetpackcompose.common.Constants
import com.jkdigitals.jkdigitaljetpackcompose.data.remote.JkDigitalAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJKDigitalAPI(): JkDigitalAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JkDigitalAPI::class.java)
    }

}