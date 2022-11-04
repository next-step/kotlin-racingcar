package com.nextstep.stringcalculator

class StringCalculator(private val expression: String) {
    val elements: List<String> = expression.split(" ")
}
