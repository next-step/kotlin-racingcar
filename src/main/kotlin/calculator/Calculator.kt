package calculator

fun calculate(input: String): Int {
    require(input.isNotBlank()) { "공백은 계산할 수 없다." }
    val values = input.split(" ")
    require(values.size % 2 == 0) { "올바른 형태로 수식을 입력하여야 한다." }

    val operands = values.filterIndexed { index, _ -> index % 2 == 0 }
        .map { parseToNumber(it) }
    val operators = values.filterIndexed { index, _ -> index % 2 == 1 }
        .map { Operator.from(it) }

    var calculatedNumber = operands.first()

    for (index in operators.indices) {
        val operand = operands[index + 1]
        val operator = operators[index]
        calculatedNumber = operator.operate(calculatedNumber, operand)
    }

    return calculatedNumber
}

private fun parseToNumber(it: String) =
    try {
        it.toInt()
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException("올바른 숫자를 입력하여야 한다.")
    }
