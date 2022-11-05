package com.nextstep.stringcalculator

class StringCalculator(input: String?) {
    private val expression: Expression
    init {
        require(input != null && input.isNotBlank()) { "Input shouldn't be null or blank" }
        this.expression = Expression(input)
    }

    fun calculate(): Long = expression.calculate()
}
