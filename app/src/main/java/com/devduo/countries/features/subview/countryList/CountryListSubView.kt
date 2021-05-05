package com.devduo.countries.features.subview.countryList

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.devduo.conutries.domain.model.CountryModel
import com.devduo.countries.adapter.CountryRecyclerAdapter
import com.devduo.countries.base.Code
import com.devduo.countries.base.helper.asyncviewstate.AsyncViewState
import com.devduo.countries.databinding.SubviewCountryListBinding
import com.devduo.countries.extension.shouldGone
import com.devduo.countries.extension.shouldVisible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CountryListSubView : ConstraintLayout{
    constructor(context: Context) : super(context)
    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs)

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    )

    companion object {
        val CODE = Code.StringCode("CountryListSubView")
    }

    @Inject lateinit var countryViewModel: CountryViewModel

    @Inject lateinit var countryRecyclerAdapter: CountryRecyclerAdapter

    private lateinit var binding:SubviewCountryListBinding

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding= SubviewCountryListBinding.bind(this)
        initUi()
        initListener()
    }

    private fun initUi(){
        binding.recyclerCountry.apply {
            this.setHasFixedSize(true)
            this.layoutManager = LinearLayoutManager(context)
            this.adapter=countryRecyclerAdapter
        }
    }

    private fun initListener(){
        countryViewModel.getCountriesLiveData.observe(context as AppCompatActivity,{
            when(it){
                is AsyncViewState.Loading -> {

                }

                is AsyncViewState.Success ->{
                    countryRecyclerAdapter.setNewData(it.value)
                }

                is AsyncViewState.Error ->{
                    Log.e("error retrieve data",it.errorMessage)
                }
            }
        })
    }

    fun visible(){
        this.shouldVisible()
        countryViewModel.doGetCountries()
    }

    fun gone(){
        this.shouldGone()
        countryViewModel.getCountriesLiveData.postLoading()
    }
}