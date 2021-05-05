package com.devduo.countries.features.subview.splash

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.devduo.countries.base.BaseDelegate
import com.devduo.countries.base.Code
import com.devduo.countries.base.helper.asyncviewstate.AsyncViewState
import com.devduo.countries.databinding.SubViewSplashBinding
import com.devduo.countries.extension.shouldGone
import com.devduo.countries.extension.shouldVisible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashSubView : ConstraintLayout {
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
        val CODE = Code.StringCode("SplashSubView")
        val CODE_DATA_READY = Code.IntCode(0)
    }

    @Inject
    lateinit var viewModel: SplashViewModel

    private lateinit var binding: SubViewSplashBinding

    var delegate: BaseDelegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = SubViewSplashBinding.bind(this)
        initListener()
    }

    private fun initListener() {
        viewModel.countryFetchLiveData.observe(context as AppCompatActivity, {
            when (it) {
                is AsyncViewState.Loading -> {

                }

                is AsyncViewState.Success -> {
                    delegate?.onAction(CODE_DATA_READY, it.value)
                }

                is AsyncViewState.Error -> {
                    Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun doOperation() {
        viewModel.fetchCountries()
    }

    fun visible() {
        this.shouldVisible()
        doOperation()
    }

    fun gone() {
        this.shouldGone()
        viewModel.countryFetchLiveData.postLoading()
    }
}