package calculator

import java.math.BigDecimal
import java.util.LinkedList
import java.util.Queue

class Calculator {

    companion object {
        const val OPERAND = "-?\\d+"
        const val OPERATOR = "[+\\-*/]"
        const val DELIMITER = " "
    }

    fun exec(str: String): BigDecimal {
        if (str.matches(Regex("$OPERAND(${DELIMITER}${OPERATOR}${DELIMITER}$OPERAND)+"))) {
            return calculate(operators(str), operands(str))
        }
        throw IllegalArgumentException("${str}은 올바른 수식이 아닙니다.")
    }

    private fun operators(str: String) = str.split(DELIMITER)
        .filter { it.matches(Regex(OPERATOR)) }
        .toCollection(LinkedList())

    private fun operands(str: String) = str.split(DELIMITER)
        .filter { it.matches(Regex(OPERAND)) }
        .map { BigDecimal(it) }
        .toCollection(LinkedList())

    private fun calculate(
        operators: Queue<String>,
        operands: Queue<BigDecimal>
    ): BigDecimal {
        var left = operands.poll()
        while (!operators.isEmpty()) {
            val operator = operators.poll()
            val right = operands.poll()
            left = operator.apply(left, right)
        }
        return left
    }

    private fun String.apply(left: BigDecimal, right: BigDecimal): BigDecimal {
        if (this == "+") {
            return left.add(right)
        }
        if (this == "*") {
            return left.multiply(right)
        }
        if (this == "/") {
            return left.divide(right)
        }
        if (this == "-") {
            return left.subtract(right)
        }
        throw IllegalStateException()
    }
}
