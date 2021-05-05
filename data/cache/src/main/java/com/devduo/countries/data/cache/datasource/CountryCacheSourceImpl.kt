package com.devduo.countries.data.cache.datasource

import com.devduo.conutries.domain.model.CountryModel
import com.devduo.countries.data.cache.realm.CountryRealm
import com.devduo.countries.data.cache.realm.toCountryModel
import com.devduo.countries.data.framework.repository.CountryCacheSource
import io.realm.Realm
import javax.inject.Inject

class CountryCacheSourceImpl @Inject constructor() : CountryCacheSource {
    override fun saveCountries(data: List<CountryModel>) {
        deleteCountries()
        val realmDB = Realm.getDefaultInstance()
        data.forEach { it ->
            realmDB.executeTransaction { realm ->
                val countryRealm = realm.createObject(CountryRealm::class.java)
                countryRealm.name = if(it.name.isNullOrEmpty()) "Unknown" else it.name
                countryRealm.capital = if(it.capital.isNullOrEmpty()) "Unknown" else it.capital
                realmDB.insertOrUpdate(countryRealm)
            }
        }

        if (!realmDB.isClosed)
            realmDB.close()
    }

    override fun getCountries(): List<CountryModel> {
        val realmDB = Realm.getDefaultInstance()
        return realmDB.where(CountryRealm::class.java).findAll().map {
            it.toCountryModel()
        }
    }

    override fun deleteCountries() {
        val realmDB = Realm.getDefaultInstance()
        realmDB.beginTransaction()
        realmDB.where(CountryRealm::class.java).findAll().deleteAllFromRealm()
        realmDB.commitTransaction()
        if (!realmDB.isClosed)
            realmDB.close()
    }
}