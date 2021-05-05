package com.devduo.countries.data.cache.di

import com.devduo.countries.data.cache.datasource.CountryCacheSourceImpl
import com.devduo.countries.data.framework.repository.CountryCacheSource
import dagger.Binds
import dagger.Module

@Module
abstract class CacheModule {
    @Binds
    abstract fun countryCacheSource(countryCacheSourceImpl: CountryCacheSourceImpl):CountryCacheSource
}