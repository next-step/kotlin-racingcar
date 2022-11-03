package step2

import step2.Operator.*
import step2.Operator.Companion.from

class StringCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) throw IllegalArgumentException("input 값은 Null, 공백이 될 수 없습니다.")

        val operators = input.split(" ")
        var accumulator = operators[0].toInt()
        for (i in 1 until operators.size step 2) {
            accumulator = calculateWith(Pair(operators[i], operators[i + 1].toInt()), accumulator)
        }
        return accumulator
    }

    private fun calculateWith(operators: Pair<String, Int>, base: Int): Int {
        val (operator, operand) = operators
        return when (from(operator)) {
            PLUS -> base + operand
            MINUS -> base - operand
            MULTIPLY -> base * operand
            DIVIDE -> base / operand
        }
    }
}
