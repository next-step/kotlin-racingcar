package com.nextstep.stringcalculator

class StringCalculator(input: String?) {
    private val expression: Expression
    init {
        require(!input.isNullOrBlank()) { "Input shouldn't be blank" }
        this.expression = Expression(input)
    }

    fun calculate(): Long = expression.calculate()
}
