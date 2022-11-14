package com.nextstep.stringcalculator

class StringCalculator {

    companion object {
        fun calculate(input: String?): Long {
            require(!input.isNullOrBlank()) { "Input shouldn't be null or blank" }
            return Expression(input).calculate()
        }
    }
}
