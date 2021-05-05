package com.devduo.countries.data.framework.repository

import com.devduo.conutries.domain.model.CountryModel

interface CountryNetworkSource {
    fun getCountries():List<CountryModel>
}