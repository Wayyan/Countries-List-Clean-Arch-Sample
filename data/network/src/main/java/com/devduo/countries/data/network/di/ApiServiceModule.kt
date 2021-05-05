package com.devduo.countries.data.network.di

import android.content.Context
import com.devduo.conutries.domain.model.K
import com.devduo.countries.data.network.api.CountryApiServices
import com.devduo.countries.data.network.api.response.CountryResponse
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object ApiServiceModule {
    private var retrofit:Retrofit?=null

    fun retrofit(context: Context):Retrofit{
        if (retrofit!=null)
            return retrofit!!

//        val moshi=Moshi.Builder()
//            .build()
//
//        val adapter = moshi.adapter(CountryResponse::class.java)

        return Retrofit.Builder().baseUrl(K.url)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpProvider.okHttpClient(context))
            .build()
    }

    @Provides
    fun countryApiService(context: Context):CountryApiServices{
        return retrofit(context).create(CountryApiServices::class.java)
    }
}