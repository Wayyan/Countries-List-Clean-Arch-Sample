package com.devduo.conutries.domain.repository

import com.devduo.conutries.domain.model.CountryModel

interface CountryRepository {
    fun fetchCountry():List<CountryModel>
    fun getCountry():List<CountryModel>
}