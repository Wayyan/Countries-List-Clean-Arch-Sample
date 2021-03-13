package com.devduo.countries.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devduo.countries.R
import com.devduo.countries.base.core.BaseActivity
import com.devduo.countries.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}