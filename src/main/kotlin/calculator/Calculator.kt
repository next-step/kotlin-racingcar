package calculator

fun calculate(input: String): Int {
    if (input.isBlank()) {
        throw IllegalArgumentException("공백은 계산할 수 없다.")
    }
    val values = input.split(" ")
    validateCalculateFormat(values)
    val operands = values.filterIndexed { index, _ -> index % 2 == 0 }
        .map { parseToNumber(it) }
    val operators = values.filterIndexed { index, _ -> index % 2 == 1 }
        .map { parseToOperator(it) }

    return 0
}

private fun validateCalculateFormat(values: List<String>) {
    if (values.size % 2 == 0) {
        throw IllegalArgumentException("올바른 형태로 수식을 입력하여야 한다.")
    }
}

private fun parseToNumber(it: String) =
    try {
        it.toInt()
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException("올바른 숫자를 입력하여야 한다.")
    }

private fun parseToOperator(it: String): String {
    if (it != "+" && it != "-" && it != "/" && it != "*") {
        throw IllegalArgumentException("올바른 연산자를 입력하여야 한다.")
    }
    return it
}
