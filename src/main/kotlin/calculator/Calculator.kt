package calculator

import java.util.stream.Collectors.toList

const val BLANK = " "
const val INDEX_FIRST = 0
const val INDEX_SECOND = 1
const val INDEX_THIRD = 2
const val TWO_STEP = 2
const val ZERO = 0

fun calculate(input: String): Int {
    val elements = splitInput(input)
    var leftSum = getInitLeftSum(elements)

    for (i in 3..(elements.size - TWO_STEP) step (TWO_STEP)) {
        val operator = elements[i]
        val right = elements[i + 1]
        leftSum = calculateSum(leftSum, right, operator)
    }

    return leftSum
}

private fun getInitLeftSum(elements: List<String>): Int {
    val left = elements[INDEX_FIRST]
    val right = elements[INDEX_THIRD]
    val operator = elements[INDEX_SECOND]

    return calculateInitLeftSum(left, right, operator)
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
    if (operator == SYMBOL_DIVIDE && rightNumber == ZERO) {
        throw IllegalArgumentException()
    }
}

private fun validateOperatorSymbol(operator: String) {
    findOperator(operator)
}

private fun validateNullOrBlank(stringNumber: String) {
    if (isEmptyOrBlank(stringNumber)) {
        throw IllegalArgumentException()
    }
}

private fun isEmptyOrBlank(stringNumber: String): Boolean {
    return stringNumber.isEmpty() || BLANK == stringNumber
}

private fun splitInput(input: String): List<String> {
    return input.split(BLANK)
        .stream()
        .map { element -> element.trim() }
        .collect(toList())
}
