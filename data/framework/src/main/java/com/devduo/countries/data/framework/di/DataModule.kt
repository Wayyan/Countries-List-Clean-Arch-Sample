package com.devduo.countries.data.framework.di

import com.devduo.conutries.domain.repository.CountryRepository
import com.devduo.countries.data.framework.repository.CountryRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun countryRepository(countryRepositoryImpl: CountryRepositoryImpl):CountryRepository
}