package calculator

import java.util.stream.Collectors.toList

const val DELIMITER = " "
const val ADD = "+"
const val SUBTRACT = "-"
const val MULTIPLY = "*"
const val DIVIDE = "/"

fun calculate(input: String): Int {
    val elements = splitInput(input)

    var left = elements[0]
    var right = elements[2]
    var operator = elements[1]
    var initLeftSum = calculateInitLeftSum(left, right, operator)
    var leftSum = initLeftSum
    for (i in 3..(elements.size - 2) step (2)) {
        val operator = elements[i]
        val right = elements[i + 1]
        leftSum = calculateSum(leftSum, right, operator)
    }

    return leftSum
}

private fun calculateSum(leftNumber: Int, right: String, operator: String): Int {
    validateNullOrBlank(right)
    validateOperatorSymbol(operator)
    val rightNumber = Integer.parseInt(right)
    validateRightNumberToDivide(operator, rightNumber)

    return operate(leftNumber, rightNumber, operator)
}

private fun calculateInitLeftSum(left: String, right: String, operator: String): Int {
    validateNullOrBlank(left)
    validateNullOrBlank(right)
    validateOperatorSymbol(operator)

    var leftNumber = Integer.parseInt(left)
    var rightNumber = Integer.parseInt(right)
    validateRightNumberToDivide(operator, rightNumber = rightNumber)

    return operate(leftNumber, rightNumber, operator)
}

private fun validateRightNumberToDivide(operator: String, rightNumber: Int) {
    if (operator == DIVIDE && rightNumber == 0) {
        throw IllegalArgumentException()
    }
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

private fun validateNullOrBlank(stringNumber: String) {
    if (isNullOrBlank(stringNumber)) {
        throw IllegalArgumentException()
    }
}

private fun isNullOrBlank(stringNumber: String): Boolean {
    return stringNumber.equals(null) || " " == stringNumber
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
