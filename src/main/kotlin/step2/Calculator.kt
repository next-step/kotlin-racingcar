package step2

import java.lang.IllegalArgumentException

class Calculator {

    fun calculate(string: String): Int {

        val splitString = CalculatorUtil.validateAndReturn(string).toMutableList()
        var sortedString = mutableListOf(" ", " ", " ")

        var result = 0

        for (i in 0..splitString.lastIndex step 2) {
            if (splitString.lastIndex < 2) break
            CalculatorUtil.parser(splitString, sortedString)
            result = calc(sortedString)
            splitString.add(0, result.toString())
        }

        return result
    }

    private fun calc(list: MutableList<String>): Int {
        return when (list[0]) {
            Operator.PLUS.getOperand() -> Operator.PLUS.apply(list[1].toInt(), list[2].toInt())
            Operator.MINUS.getOperand() -> Operator.MINUS.apply(list[1].toInt(), list[2].toInt())
            Operator.TIMES.getOperand() -> Operator.TIMES.apply(list[1].toInt(), list[2].toInt())
            Operator.DIV.getOperand() -> Operator.DIV.apply(list[1].toInt(), list[2].toInt())
            else -> throw IllegalArgumentException("잘못된 연산자입니다")
        }
    }
}
