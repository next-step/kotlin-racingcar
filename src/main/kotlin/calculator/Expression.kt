package calculator

import kotlin.streams.toList

class Expression(values: List<String>) {

    private val operands: MutableList<Int>
    private val operators: MutableList<String>

    init {
        operators = values.stream()
            .filter { STRING_OPERATORS.contains(it) }
            .toList()
            .toMutableList()

        operands = values.stream()
            .filter { !STRING_OPERATORS.contains(it) }
            .map { it.toInt() }
            .toList()
            .toMutableList()
    }

    fun calculate(): Int {

        operators.forEach {
            val operator = Operators.getOperator(it)
            val first = operands.removeFirst()
            val second = operands.first()
            val result = operator.calculate(first, second).toInt()
            operands[FIRST_INDEX] = result
        }
        return operands[FIRST_INDEX]
    }

    companion object {
        const val FIRST_INDEX = 0
        val STRING_OPERATORS: List<String> = listOf("+", "-", "*", "/")
    }
}
