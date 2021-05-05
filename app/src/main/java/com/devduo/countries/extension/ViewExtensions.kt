package com.devduo.countries.extension

import android.view.View

fun View.shouldVisible(){
    if(this.visibility!=View.VISIBLE)
        this.visibility=View.VISIBLE
}

fun View.shouldGone(){
    if(this.visibility!=View.GONE)
        this.visibility=View.GONE
}