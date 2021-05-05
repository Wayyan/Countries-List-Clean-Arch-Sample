package com.devduo.countries.features

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devduo.conutries.domain.model.CountryModel
import com.devduo.countries.base.Code

class MainViewModel @ViewModelInject constructor() : ViewModel() {
    val subViewStateLiveData=MutableLiveData<Code>()
}