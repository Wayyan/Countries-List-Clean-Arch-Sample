package com.devduo.countries.di

import android.content.Context
import com.devduo.countries.adapter.CountryRecyclerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {
    @Provides
    fun provideCountryRecyclerAdapter(@ApplicationContext context: Context) =
        CountryRecyclerAdapter(context)
}