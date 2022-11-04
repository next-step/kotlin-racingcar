package com.nextstep.stringcalculator

class StringCalculator(private val input: String) {
    private val expression: Expression
    init {
        if (input.isBlank()) throw IllegalArgumentException("Input shouldn't be blank")
        this.expression = Expression(input)
    }

    fun calculate(): Long = expression.calculate()
}
