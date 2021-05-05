package com.devduo.countries.data.framework.repository

import com.devduo.conutries.domain.model.CountryModel
import com.devduo.conutries.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryNetworkSource: CountryNetworkSource,
    private val countryCacheSource: CountryCacheSource
) : CountryRepository {
    override fun fetchCountry(): List<CountryModel> {
        val data = countryNetworkSource.getCountries()
        if (data.isNotEmpty())
            countryCacheSource.saveCountries(data)
        return data
    }

    override fun getCountry(): List<CountryModel> {
        return countryCacheSource.getCountries()
    }
}