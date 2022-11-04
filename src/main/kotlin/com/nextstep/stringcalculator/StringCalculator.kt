package com.nextstep.stringcalculator

class StringCalculator(private val expression: String) {
    val elements: List<Element>
    init {
        if (expression.isBlank()) throw IllegalArgumentException("Input shouldn't be blank")
        elements = expression.split(" ")
            .mapIndexed { idx, s -> if (isNumber(idx)) Number(s) else Operator.find(s) }
    }
    private fun isNumber(idx: Int) = idx % 2 == 0
}
