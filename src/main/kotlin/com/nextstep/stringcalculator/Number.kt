package com.nextstep.stringcalculator

data class Number(private val input: String) : Element {
    val number: Long = input.toLong()
}
