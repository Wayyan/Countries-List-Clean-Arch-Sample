package com.devduo.conutries.domain.usecase

import com.devduo.conutries.domain.CoroutineUseCase
import com.devduo.conutries.domain.DispatcherProvider
import com.devduo.conutries.domain.model.CountryModel
import com.devduo.conutries.domain.repository.CountryRepository
import javax.inject.Inject

class FetchCountry @Inject constructor(
    private val countryRepository: CountryRepository,
    dispatcher:DispatcherProvider):CoroutineUseCase<Unit,List<CountryModel>> (dispatcherProvider = dispatcher){
    override fun provide(input: Unit): List<CountryModel> {
        return countryRepository.fetchCountry()
    }
}