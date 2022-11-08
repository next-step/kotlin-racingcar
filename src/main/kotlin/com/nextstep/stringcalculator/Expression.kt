package com.nextstep.stringcalculator

private const val delimiter = " "

class Expression(expression: String) {
    val elements: List<Element>

    init {
        try {
            elements = expression.split(delimiter)
                .mapIndexed { idx, s -> if (isNumber(idx)) Operand(s) else Operator.find(s) }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Input expression is invalid, $expression")
        }
        require(elements.last() is Operand) { "Input expression is invalid, $expression" }
    }

    private fun isNumber(idx: Int): Boolean = idx % 2 == 0

    fun calculate(): Long {
        var left: Operand = elements[0] as Operand
        for (idx in 1 until elements.size step 2) {
            val operator = elements[idx] as Operator
            val right = elements[idx + 1] as Operand
            left = operator.calculate(left, right)
        }
        return left.value
    }
}
