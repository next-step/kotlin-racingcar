package com.nextstep.stringcalculator

enum class Operator(val symbol: String, val calculate: (Number, Number) -> Number) : Element {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    fun apply(left: Number, right: Number): Number = this.calculate(left, right)

    companion object {
        fun find(input: String): Operator {
            val found = Operator.values().find { it.symbol == input }
            return found ?: throw IllegalArgumentException("string operator should be one of (+, -, *, /), it was: $input")
        }
    }
}
