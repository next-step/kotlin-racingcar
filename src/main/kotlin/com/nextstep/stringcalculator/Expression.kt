package com.nextstep.stringcalculator

class Expression(private val expression: String) {
    val elements: List<Element>
    init {
        elements = expression.split(" ")
            .mapIndexed { idx, s -> if (isNumber(idx)) Number(s) else Operator.find(s) }
    }

    private fun isNumber(idx: Int) = idx % 2 == 0

    fun calculate(): Long {
        var result: Long = (elements[0] as Number).number
        for (idx in elements.indices step 3) {
            val operator = elements[idx + 1] as Operator
            val right = (elements[idx + 2] as Number).number

            result = operator.calculate(result, right)
        }
        return result
    }
}
