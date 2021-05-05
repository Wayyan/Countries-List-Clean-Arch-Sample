package com.devduo.countries.data.network.di

import com.devduo.countries.data.framework.repository.CountryNetworkSource
import com.devduo.countries.data.network.datasource.CountryNetworkSourceImpl
import dagger.Binds
import dagger.Module

@Module(includes = [ApiServiceModule::class])
abstract class NetworkModule {
    @Binds
    abstract fun countryNetworkSource(countryNetworkSourceImpl: CountryNetworkSourceImpl):CountryNetworkSource
}