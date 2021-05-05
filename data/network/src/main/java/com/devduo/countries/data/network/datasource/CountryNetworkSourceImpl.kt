package com.devduo.countries.data.network.datasource

import com.devduo.conutries.domain.model.CountryModel
import com.devduo.countries.data.framework.repository.CountryNetworkSource
import com.devduo.countries.data.network.api.CountryApiServices
import com.devduo.countries.data.network.api.response.CountryResponse
import com.devduo.countries.data.network.exception.NoContentException
import com.devduo.countries.data.network.extension.executeOrThrow
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

class CountryNetworkSourceImpl @Inject constructor(private val countryApiServices: CountryApiServices) :
    CountryNetworkSource {
    override fun getCountries(): List<CountryModel> {
        val rawResponse = countryApiServices.getCountryList().executeOrThrow()

//        val sampleResponse = "[{\"name\":\"Afghanistan\",\"topLevelDomain\":[\".af\"],\"alpha2Code\":\"AF\",\"alpha3Code\":\"AFG\",\"callingCodes\":[\"93\"],\"capital\":\"Kabul\",\"altSpellings\":[\"AF\",\"Afġānistān\"],\"region\":\"Asia\",\"subregion\":\"Southern Asia\",\"population\":27657145,\"latlng\":[33.0,65.0],\"demonym\":\"Afghan\",\"area\":652230.0,\"gini\":27.8,\"timezones\":[\"UTC+04:30\"],\"borders\":[\"IRN\",\"PAK\",\"TKM\",\"UZB\",\"TJK\",\"CHN\"],\"nativeName\":\"افغانستان\",\"numericCode\":\"004\",\"currencies\":[{\"code\":\"AFN\",\"name\":\"Afghan afghani\",\"symbol\":\"؋\"}],\"languages\":[{\"iso639_1\":\"ps\",\"iso639_2\":\"pus\",\"name\":\"Pashto\",\"nativeName\":\"پښتو\"},{\"iso639_1\":\"uz\",\"iso639_2\":\"uzb\",\"name\":\"Uzbek\",\"nativeName\":\"Oʻzbek\"},{\"iso639_1\":\"tk\",\"iso639_2\":\"tuk\",\"name\":\"Turkmen\",\"nativeName\":\"Türkmen\"}],\"translations\":{\"de\":\"Afghanistan\",\"es\":\"Afganistán\",\"fr\":\"Afghanistan\",\"ja\":\"アフガニスタン\",\"it\":\"Afghanistan\",\"br\":\"Afeganistão\",\"pt\":\"Afeganistão\",\"nl\":\"Afghanistan\",\"hr\":\"Afganistan\",\"fa\":\"افغانستان\"},\"flag\":\"https://restcountries.eu/data/afg.svg\",\"regionalBlocs\":[{\"acronym\":\"SAARC\",\"name\":\"South Asian Association for Regional Cooperation\",\"otherAcronyms\":[],\"otherNames\":[]}],\"cioc\":\"AFG\"},{\"name\":\"Afghanistan\",\"topLevelDomain\":[\".af\"],\"alpha2Code\":\"AF\",\"alpha3Code\":\"AFG\",\"callingCodes\":[\"93\"],\"capital\":\"Kabul\",\"altSpellings\":[\"AF\",\"Afġānistān\"],\"region\":\"Asia\",\"subregion\":\"Southern Asia\",\"population\":27657145,\"latlng\":[33.0,65.0],\"demonym\":\"Afghan\",\"area\":652230.0,\"gini\":27.8,\"timezones\":[\"UTC+04:30\"],\"borders\":[\"IRN\",\"PAK\",\"TKM\",\"UZB\",\"TJK\",\"CHN\"],\"nativeName\":\"افغانستان\",\"numericCode\":\"004\",\"currencies\":[{\"code\":\"AFN\",\"name\":\"Afghan afghani\",\"symbol\":\"؋\"}],\"languages\":[{\"iso639_1\":\"ps\",\"iso639_2\":\"pus\",\"name\":\"Pashto\",\"nativeName\":\"پښتو\"},{\"iso639_1\":\"uz\",\"iso639_2\":\"uzb\",\"name\":\"Uzbek\",\"nativeName\":\"Oʻzbek\"},{\"iso639_1\":\"tk\",\"iso639_2\":\"tuk\",\"name\":\"Turkmen\",\"nativeName\":\"Türkmen\"}],\"translations\":{\"de\":\"Afghanistan\",\"es\":\"Afganistán\",\"fr\":\"Afghanistan\",\"ja\":\"アフガニスタン\",\"it\":\"Afghanistan\",\"br\":\"Afeganistão\",\"pt\":\"Afeganistão\",\"nl\":\"Afghanistan\",\"hr\":\"Afganistan\",\"fa\":\"افغانستان\"},\"flag\":\"https://restcountries.eu/data/afg.svg\",\"regionalBlocs\":[{\"acronym\":\"SAARC\",\"name\":\"South Asian Association for Regional Cooperation\",\"otherAcronyms\":[],\"otherNames\":[]}],\"cioc\":\"AFG\"}]"
//
//        val moshi = Moshi.Builder()
//            .build()
//
//        val type = Types.newParameterizedType(List::class.java,CountryResponse::class.java)
//
//        val adapter : JsonAdapter<List<CountryResponse>> = moshi.adapter(type)
//
//        val response = adapter.fromJson(sampleResponse)

        return if (rawResponse.isNullOrEmpty())
            throw NoContentException()
        else
            rawResponse.map {
                it.mapToCountryModel()
            }
    }
}