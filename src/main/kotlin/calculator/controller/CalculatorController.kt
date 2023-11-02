package calculator.controller

import calculator.domain.Calculator

class CalculatorController(
    private val words: List<String>,
    private val calculator: Calculator,
) {

    fun getResult(): Int {
        var result = getFirstOperand()

        for (i in 1 until words.size step 2) {
            val operator = getOperator(i)
            val operand = getNextOperand(i)
            result = calculator.calculate(result, operator, operand)
        }

        return result
    }

    private fun getFirstOperand(): Int {
        try {
            return Integer.parseInt(words[0])
        } catch (e: Exception) {
            throw IllegalArgumentException("피연산자는 숫자만 가능합니다.")
        }
    }

    private fun getOperator(i: Int): Char {
        try {
            return words[i].single()
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자와 연산자 사이에는 공백이 있어야 합니다.")
        }
    }

    private fun getNextOperand(i: Int): Int {
        try {
            return Integer.parseInt(words[i + 1])
        } catch (e: Exception) {
            throw IllegalArgumentException("반드시 연산하고자 하는 숫자를 입력해야 합니다.")
        }
    }
}
