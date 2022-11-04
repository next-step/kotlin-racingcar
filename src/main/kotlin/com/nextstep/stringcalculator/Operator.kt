package com.nextstep.stringcalculator

enum class Operator(val symbol: String, val calculate: (Long, Long) -> Long) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    fun apply(leftNumber: Long, rightNumber: Long): Long = this.calculate(leftNumber, rightNumber)
}
