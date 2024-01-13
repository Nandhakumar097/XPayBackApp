package com.example.mylistapp.module

import com.example.mylistapp.remote.MyApi
import com.example.mylistapp.repository.MyRepository
import com.example.mylistapp.repository.MyRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyModule {

    @Singleton
    @Provides
    fun provideMyRepository(myApi: MyApi) : MyRepository{
        return MyRepositoryImp(myApi)
    }

    @Singleton
    @Provides
    fun provideMyApi() : MyApi{
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }


}