package calculator

const val BLANK = " "
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
    val (left, operator, right) = elements

    return calculateInitLeftSum(left, right, operator)
}

private fun calculateSum(leftNumber: Int, right: String, operator: String): Int {
    validateBlank(right)
    validateOperatorSymbol(operator)
    val rightNumber = Integer.parseInt(right)
    validateRightNumberToDivide(operator, rightNumber)

    return Operator.operate(leftNumber, rightNumber, operator)
}

private fun calculateInitLeftSum(left: String, right: String, operator: String): Int {
    validateBlank(left)
    validateBlank(right)
    validateOperatorSymbol(operator)

    val leftNumber = Integer.parseInt(left)
    val rightNumber = Integer.parseInt(right)
    validateRightNumberToDivide(operator, rightNumber = rightNumber)

    return Operator.operate(leftNumber, rightNumber, operator)
}

private fun validateRightNumberToDivide(operator: String, rightNumber: Int) {
    if (operator == SYMBOL_DIVIDE && rightNumber == ZERO) {
        throw IllegalArgumentException("Failed validateRightNumberToDivide. operator:$operator, rightNumber:$rightNumber")
    }
}

private fun validateOperatorSymbol(operator: String) {
    Operator.findOperator(operator)
}

private fun validateBlank(stringNumber: String) {
    if (stringNumber.isBlank()) {
        throw IllegalArgumentException("Failed validateBlank")
    }
}

private fun splitInput(input: String): List<String> {
    return input.split(BLANK)
        .asSequence()
        .map { element -> element.trim() }
        .toList()
}
