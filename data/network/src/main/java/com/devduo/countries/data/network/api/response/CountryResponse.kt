package com.devduo.countries.data.network.api.response

import com.devduo.conutries.domain.model.CountryModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryResponse(
    @Json(name = "name") val name: String,
    @Json(name = "capital") val capital: String
) {
    fun mapToCountryModel(): CountryModel {
        return CountryModel(
            name = name,
            capital = capital
        )
    }
}