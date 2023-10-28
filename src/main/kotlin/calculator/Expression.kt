package calculator

import java.math.BigDecimal
import java.util.LinkedList
import java.util.Queue

class Expression(private val value: String) {

    init {
        if (!isValidExpression(value)) {
            throw IllegalArgumentException("${value}은 올바른 수식이 아닙니다.")
        }
    }

    private fun isValidExpression(str: String): Boolean {
        return str.matches(Regex("$OPERAND($DELIMITER${Operator.regex()}$DELIMITER$OPERAND)+"))
    }

    fun operators(): Queue<Operator> = value.split()
        .filter { it.matches(Operator.regex()) }
        .map { Operator.findBy(it) }
        .toCollection(LinkedList())

    fun operands(): Queue<BigDecimal> = value.split()
        .filter { it.matches(Regex(OPERAND)) }
        .map { BigDecimal(it) }
        .toCollection(LinkedList())

    private fun String.split(): List<String> = split(DELIMITER)

    companion object {
        private const val OPERAND = "-?\\d+"
        private const val DELIMITER = " "
    }
}
