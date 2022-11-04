package com.nextstep.stringcalculator

class StringCalculator(private val expression: String) {
    val elements: List<Element> = expression.split(" ")
        .mapIndexed { idx, s -> if (isNumber(idx)) Number(s) else Operator.find(s) }

    private fun isNumber(idx: Int) = idx % 2 == 0
}
