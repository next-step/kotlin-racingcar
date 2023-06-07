package calculator

fun calculate(input: String): Int {
    require(input.isNotBlank()) { "공백은 계산할 수 없다." }
    val values = input.split(" ")
    require(isOdd(values.size)) { "올바른 형태로 수식을 입력하여야 한다." }

    val operands = values.filterIndexed { index, _ -> isEven(index) }
        .map { parseToNumber(it) }
    val operators = values.filterIndexed { index, _ -> isOdd(index) }
        .map { Operator.from(it) }

    var calculatedNumber = operands.first()

    for (index in operators.indices) {
        val operand = operands[index + 1]
        val operator = operators[index]
        calculatedNumber = operator.operate(calculatedNumber, operand)
    }

    return calculatedNumber
}

private fun isOdd(number: Int) = (number % 2) == 1

private fun isEven(number: Int) = (number % 2) == 0

private fun parseToNumber(it: String) =
    try {
        it.toInt()
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException("올바른 숫자를 입력하여야 한다.")
    }
