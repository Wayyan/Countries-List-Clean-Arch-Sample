package com.devduo.countries.features.subview.countryList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devduo.conutries.domain.model.CountryModel
import com.devduo.conutries.domain.usecase.GetCountries
import com.devduo.countries.base.helper.asyncviewstate.AsyncViewStateLiveData
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountryViewModel @Inject constructor(private val getCountries: GetCountries):ViewModel() {
    val getCountriesLiveData=AsyncViewStateLiveData<List<CountryModel>>()

    fun doGetCountries(){
        viewModelScope.launch {
            getCountriesLiveData.postLoading()
            val result = kotlin.runCatching {
                val data = getCountries.execute(Unit)
                getCountriesLiveData.postSuccess(data)
            }
            result.exceptionOrNull()?.let {
                getCountriesLiveData.postError(it,it.localizedMessage)
            }
        }
    }
}