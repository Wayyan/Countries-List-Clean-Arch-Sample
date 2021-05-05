package com.devduo.countries.adapter

import android.content.Context
import android.view.ViewGroup
import com.devduo.conutries.domain.model.CountryModel
import com.devduo.countries.base.core.BaseRecyclerAdapter
import com.devduo.countries.base.core.BaseRecyclerViewHolder
import com.devduo.countries.databinding.ItemCountryBinding
import javax.inject.Inject

class CountryRecyclerAdapter @Inject constructor(private val context: Context) :
    BaseRecyclerAdapter<CountryRecyclerAdapter.CountryViewHolder, CountryModel>(context) {
    inner class CountryViewHolder(private val binding: ItemCountryBinding) :
        BaseRecyclerViewHolder<CountryModel>(binding.root) {
        override fun bind(model: CountryModel) {
            binding.tvCountryName.text = model.name
            binding.tvCapitalName.text = model.capital
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding=ItemCountryBinding.inflate(mLayoutInflater,parent,false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       holder.bind(mData[position])
    }

}