package calculator

import kotlin.streams.toList

class CustomStringDelimiter(value: String?) {

    private val values: List<String>
    private val operands: MutableList<Int>
    private val operators: MutableList<String>

    init {

        values = validate(value)
        operators = values.stream()
            .filter { Expression.STRING_OPERATORS.contains(it) }
            .toList()
            .toMutableList()

        operands = values.stream()
            .filter { !Expression.STRING_OPERATORS.contains(it) }
            .map { it.toInt() }
            .toList()
            .toMutableList()
    }

    private fun validate(value: String?): List<String> {
        if (value == null) {
            throw IllegalArgumentException("잘못된 값이 전달되었습니다.")
        }

        if (value.isBlank() || value.isEmpty()) {
            throw IllegalArgumentException("잘못된 값이 전달되었습니다.")
        }

        return value.split(DELIMITER)
            .toList()
    }

    fun getOperands(): MutableList<Int> {
        return operands.toMutableList()
    }

    fun getOperators(): MutableList<String> {
        return operators.toMutableList()
    }

    companion object {
        private const val DELIMITER: String = " "
    }
}
