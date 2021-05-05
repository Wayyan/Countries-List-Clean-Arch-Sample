package com.devduo.countries.features.subview.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devduo.conutries.domain.model.CountryModel
import com.devduo.conutries.domain.usecase.FetchCountry
import com.devduo.countries.base.helper.asyncviewstate.AsyncViewStateLiveData
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val fetchCountry: FetchCountry) :ViewModel() {
    val countryFetchLiveData=AsyncViewStateLiveData<List<CountryModel>>()

    fun fetchCountries(){
        viewModelScope.launch {
            countryFetchLiveData.postLoading()
            val result=kotlin.runCatching {
                val data = fetchCountry.execute(Unit)
                countryFetchLiveData.postSuccess(data)
            }

            result.exceptionOrNull()?.let {
                it.printStackTrace()
                countryFetchLiveData.postError(it,"Error Fetching Country List!")
            }
        }
    }
}