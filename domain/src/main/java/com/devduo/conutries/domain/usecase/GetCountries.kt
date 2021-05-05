package com.devduo.conutries.domain.usecase

import com.devduo.conutries.domain.CoroutineUseCase
import com.devduo.conutries.domain.DispatcherProvider
import com.devduo.conutries.domain.model.CountryModel
import com.devduo.conutries.domain.repository.CountryRepository
import javax.inject.Inject

class GetCountries @Inject constructor(
    val repository: CountryRepository,
    dispatcherProvider: DispatcherProvider
) : CoroutineUseCase<Unit, List<CountryModel>>(dispatcherProvider) {
    override fun provide(input: Unit): List<CountryModel> {
        return repository.getCountry()
    }
}