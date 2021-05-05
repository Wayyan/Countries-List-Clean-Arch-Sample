package com.devduo.countries.features

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.devduo.conutries.domain.model.CountryModel
import com.devduo.countries.base.BaseDelegate
import com.devduo.countries.base.Code
import com.devduo.countries.base.core.BaseActivity
import com.devduo.countries.databinding.ActivityMainBinding
import com.devduo.countries.features.subview.countryList.CountryListSubView
import com.devduo.countries.features.subview.splash.SplashSubView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    private lateinit var splashSubView: SplashSubView
    private lateinit var countryListSubView: CountryListSubView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        initListener()
        viewModel.subViewStateLiveData.postValue(SplashSubView.CODE)
    }

    private fun initUi() {
        splashSubView = binding.layoutSplash.root
        splashSubView.delegate = object : BaseDelegate {
            override fun onAction(code: Code, data: Any?) {
                if (code == SplashSubView.CODE_DATA_READY) {
                    val countryData = data as List<CountryModel>
                    Toast.makeText(
                        applicationContext,
                        "${countryData.size} countries are found from server.",
                        Toast.LENGTH_SHORT
                    ).show()
                    viewModel.subViewStateLiveData.postValue(CountryListSubView.CODE)
                }
            }
        }

        countryListSubView = binding.layoutCountryList.root

    }

    private fun initListener(){
        viewModel.subViewStateLiveData.observe(this, {
            controlSplashScreenState(it)
            controlCountryListScreenState(it)
        })
    }

    private fun controlSplashScreenState(code: Code) {
        splashSubView.apply {
            if (code == SplashSubView.CODE)
                this.visible()
            else
                this.gone()
        }
    }

    private fun controlCountryListScreenState(code:Code){
        countryListSubView.apply {
            if(code==CountryListSubView.CODE){
                this.visible()
            }else{
                this.gone()
            }
        }
    }
}