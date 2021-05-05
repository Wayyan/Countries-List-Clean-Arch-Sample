package com.devduo.countries.data.cache.realm

import com.devduo.conutries.domain.model.CountryModel
import io.realm.RealmObject

open class CountryRealm : RealmObject() {
    var name: String = ""
    var capital: String = ""
}

fun CountryRealm.toCountryModel(): CountryModel {
    return CountryModel(name = this.name, capital = this.capital)
}