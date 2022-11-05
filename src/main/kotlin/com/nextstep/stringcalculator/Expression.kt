package com.nextstep.stringcalculator

private const val delimiter = " "

class Expression(expression: String) {
    val elements: List<Element>

    init {
        try {
            elements = expression.split(delimiter)
                .mapIndexed { idx, s -> if (isNumber(idx)) Number(s) else Operator.find(s) }
            require(elements.last() is Number)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Input expression is invalid, $expression")
        }
    }

    private fun isNumber(idx: Int) = idx % 2 == 0

    fun calculate(): Long {
        var left: Number = elements[0] as Number
        for (idx in 1 until elements.size step 2) {
            val operator = elements[idx] as Operator
            val right = elements[idx + 1] as Number
            left = operator.calculate(left, right)
        }
        return left.value
    }
}
