package calculator

import number.Numbers.toInt

object Calculator {
    private const val FIRST_OPERAND = 0
    private const val START_INDEX = 0
    private const val OPERAND_INDEX = 2
    private const val OPERATOR_INDEX = 1
    private const val CALCULATOR_SEPARATOR = " "
    private const val SIZE_TO_LAST_OPERAND = 2

    fun input(value: String): List<String> {
        validInputIsEmpty(value)

        return splitByWhiteSpace(value)
    }

    private fun validInputIsEmpty(input: String) {
        require(!input.isBlank()) { "입력 값이 존재하지 않습니다." }
    }

    fun splitByWhiteSpace(input: String): List<String> {
        return input.split(CALCULATOR_SEPARATOR)
    }

    fun calculate(splitInput: List<String>): Int {
        var operand = splitInput[FIRST_OPERAND]

        for (index in START_INDEX until splitInput.size - SIZE_TO_LAST_OPERAND step OPERAND_INDEX) {
            val operator = Operator.operatorOf(splitInput[index + OPERATOR_INDEX])
            operand = operator.operate(toInt(operand), toInt(splitInput[index + OPERAND_INDEX])).toString()
        }

        return toInt(operand)
    }

    fun add(left: Int, right: Int): Int {
        return left + right
    }

    fun minus(left: Int, right: Int): Int {
        return left - right
    }

    fun multiply(left: Int, right: Int): Int {
        return left * right
    }

    fun division(left: Int, right: Int): Int {
        require(right != 0) { "0은 분모가 될 수 없습니다." }

        return left / right
    }
}
