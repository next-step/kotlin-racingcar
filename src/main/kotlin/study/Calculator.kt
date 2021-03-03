package study

fun calculate(input: String?): Int {
    return checkNullAndBlank(input)
        .split(" ")
        .fold("" to "") { accumulator, element ->
            operation(accumulator, element)
        }
        .first.toInt()
}

fun operation(accumulator: Pair<String, String>, element: String): Pair<String, String> {
    if (isOperator(element)) {
        return accumulator.first to element
    }

    if (accumulator.first == "") {
        return element to ""
    }

    val result = execute(accumulator.first.toInt(), element.toInt(), accumulator.second)
    return "$result" to ""
}

fun execute(firstValue: Int, secondValue: Int, operator: String): Int {
    return when (operator) {
        "+" -> firstValue + secondValue
        "-" -> firstValue - secondValue
        "*" -> firstValue * secondValue
        "/" -> firstValue / secondValue
        else -> throw IllegalArgumentException()
    }
}

fun checkNullAndBlank(input: String?): String {
    return input?.takeIf { input.isNotBlank() } ?: throw IllegalArgumentException()
}

fun isOperator(value: String): Boolean {
    val regex = Regex("[+\\-*/]")
    return regex.matches(value)
}
