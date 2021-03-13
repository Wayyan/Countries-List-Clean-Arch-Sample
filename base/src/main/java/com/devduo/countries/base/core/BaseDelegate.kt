package com.devduo.countries.base

interface BaseDelegate {
    fun onAction(
        code: Code,
        data: Any?
    )
}

sealed class Code {
    data class StringCode(val code: String) : Code()
    data class IntCode(val code: Int) : Code()
}