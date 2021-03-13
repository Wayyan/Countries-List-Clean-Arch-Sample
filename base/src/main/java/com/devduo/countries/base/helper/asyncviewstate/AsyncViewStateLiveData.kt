package com.devduo.countries.base.helper.asyncviewstate

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * A lifecycle-aware observable that sends Error state only once but revert back to normal LiveData
 * for Loading and Success. This is to prevent Error from being shown again to user on config changes
 */

class AsyncViewStateLiveData<T> : LiveData<AsyncViewState<T>>() {

    override fun observe(
        owner: LifecycleOwner,
        observer: Observer<in AsyncViewState<T>>
    ) {
        if (hasActiveObservers()) {
            Log.d("AsyncViewStateLiveData",
                "Multiple observers registered but only one will be notified of changes."
            )
        }
        super.observe(owner, observer)
    }

    fun postLoading() {
        this.postValue(AsyncViewState.Loading())
    }

    fun postSuccess(data: T) {
        this.postValue(AsyncViewState.Success(data))
    }

    fun postError(
        exception: Throwable,
        error: String
    ) {
        this.postValue(AsyncViewState.Error(exception, error))
    }

}