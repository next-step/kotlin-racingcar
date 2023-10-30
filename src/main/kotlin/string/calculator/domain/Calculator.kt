package string.calculator.domain

class Calculator(private val numbers: MutableList<Long>, private val operators: MutableList<Operator>) {
    init {
        validateInput(numbers, operators)
    }

    fun calculate(): Long {
        var result = numbers.removeFirst()

        for (i in operators.indices) {
            result = operators[i].operate(result, numbers[i])
        }

        return result
    }

    private fun validateInput(numbers: MutableList<Long>, operators: MutableList<Operator>) {
        require(numbers.isNotEmpty()) { throw IllegalArgumentException(NUMBER_NOT_ENTERED) }
        require(operators.isNotEmpty()) { throw IllegalArgumentException(OPERATOR_NOT_ENTERED) }
        require(numbers.size >= MIN_OPERAND_SIZE) { throw IllegalArgumentException(OPERAND_COUNT_MISMATCH) }
        require(numbers.size == operators.size + 1) { throw IllegalArgumentException(INPUT_IS_NOT_VALID) }
    }

    companion object {
        const val MIN_OPERAND_SIZE = 2
        const val NUMBER_NOT_ENTERED = "숫자가 입력되지 않았습니다."
        const val OPERATOR_NOT_ENTERED = "연산자가 입력되지 않았습니다."
        const val OPERAND_COUNT_MISMATCH = "피연산자의 개수는 최소 2개입니다."
        const val INPUT_IS_NOT_VALID = "입력값이 올바르지 않습니다."
    }
}
