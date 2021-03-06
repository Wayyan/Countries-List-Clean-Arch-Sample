package com.devduo.countries.base.di

import com.devduo.conutries.domain.DispatcherProvider
import com.devduo.countries.base.DefaultDispatcherProvider
import com.devduo.countries.data.cache.di.CacheModule
import com.devduo.countries.data.framework.di.DataModule
import com.devduo.countries.data.network.di.NetworkModule
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module(includes = [DataModule::class,NetworkModule::class,CacheModule::class])
abstract class BaseAppModule {
    @Binds
    abstract fun dispatcherProvider(defaultDispatcherProvider: DefaultDispatcherProvider):DispatcherProvider
}