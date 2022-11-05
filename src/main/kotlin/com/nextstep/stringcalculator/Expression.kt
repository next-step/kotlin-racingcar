package com.nextstep.stringcalculator

class Expression(private val expression: String) {
    val elements: List<Element>
    init {
        elements = expression.split(" ")
            .mapIndexed { idx, s -> if (isNumber(idx)) Number(s) else Operator.find(s) }
    }

    private fun isNumber(idx: Int) = idx % 2 == 0

    fun calculate(): Long {
        var left: Long = (elements[0] as Number).number // TODO: 2022/11/05 0으로 나누는 경우 처리, 연산자로 끝나는 잘못된 식 처리
        for (idx in 1 until elements.size step 2) {
            val operator = elements[idx] as Operator
            val right = (elements[idx + 1] as Number).number
            left = operator.calculate(left, right)
        }
        return left
    }
}
