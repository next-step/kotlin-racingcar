package calculator

class CustomStringDelimiter(value: String?) {

    private val operands: MutableList<Int>
    private val operators: MutableList<String>

    init {
        validate(value)
        val values = value!!.split(DELIMITER)
            .toList()

        operators = values
            .filter { Expression.STRING_OPERATORS.contains(it) }
            .toMutableList()

        operands = values
            .filter { !Expression.STRING_OPERATORS.contains(it) }
            .map { it.toInt() }
            .toMutableList()
    }

    private fun validate(value: String?) {
        require(value.isNullOrBlank()) { "잘못된 값이 전달되었습니다." }
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
