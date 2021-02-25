package calculator

import java.util.stream.Collectors.toList

const val DELIMITER = " "
const val ADD = "+"
const val SUBTRACT = "-"
const val MULTIPLY = "*"
const val DIVIDE = "/"

fun calculate(input: String): Int {
    val elements = splitInput(input)

    val left = elements[0]
    val right = elements[2]
    val operator = elements[1]
    validateStringNumbers(left, right)
    validateOperatorSymbol(operator)

    val leftNumber = Integer.parseInt(left)
    val rightNumber = Integer.parseInt(right)

    return operate(leftNumber, rightNumber, operator)
}

private fun validateOperatorSymbol(operator: String) {
    if (!isOperator(operator)) {
        throw java.lang.IllegalArgumentException()
    }
}

private fun isOperator(operator: String): Boolean {
    return operator == ADD ||
        operator == SUBTRACT ||
        operator == DIVIDE ||
        operator == MULTIPLY
}

private fun validateStringNumbers(left: String, right: String) {
    if (isNullOrBlank(left) || isNullOrBlank(right)) {
        throw IllegalArgumentException()
    }
}

private fun isNullOrBlank(stringNumber: String): Boolean {
    return stringNumber.equals(null) || " ".equals(stringNumber)
}

private fun operate(leftNumber: Int, rightNumber: Int, operator: String): Int {
    return when (operator) {
        ADD -> leftNumber + rightNumber
        SUBTRACT -> leftNumber - rightNumber
        MULTIPLY -> leftNumber * rightNumber
        DIVIDE -> leftNumber / rightNumber
        else -> throw IllegalArgumentException()
    }
}

private fun splitInput(input: String): List<String> {
    return input.split(DELIMITER)
        .stream()
        .map { element -> element.trim() }
        .collect(toList())
}
