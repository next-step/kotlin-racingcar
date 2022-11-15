package com.nextstep.stringcalculator

enum class Operator(val symbol: String, val calculate: (Operand, Operand) -> Operand) : Element {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun find(input: String): Operator {
            return Operator.values().find { it.symbol == input }
                ?: throw IllegalArgumentException("String operator should be one of (+, -, *, /), it was: $input")
        }
    }
}
