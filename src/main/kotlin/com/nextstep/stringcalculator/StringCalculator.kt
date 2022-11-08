package com.nextstep.stringcalculator

class StringCalculator {

    companion object {
        fun calculate(input: String?): Long {
            require(input != null && input.isNotBlank()) { "Input shouldn't be null or blank" }
            return Expression(input).calculate()
        }
    }
}
