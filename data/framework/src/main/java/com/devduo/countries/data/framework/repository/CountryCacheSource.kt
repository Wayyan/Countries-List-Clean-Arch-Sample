package com.devduo.countries.data.framework.repository

import com.devduo.conutries.domain.model.CountryModel

interface CountryCacheSource {
    fun saveCountries(data:List<CountryModel>)
    fun getCountries():List<CountryModel>
    fun deleteCountries()
}