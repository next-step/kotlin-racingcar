package calculator

fun calculate(input: String?): Int {
    require(input != null && input.isNotBlank()) { "input value is null or blank." }
    return input
        .split(" ")
        .fold(0 to Operator.PLUS) { accumulator, element ->
            operate(accumulator, element)
        }
        .first
}

fun operate(accumulator: Pair<Int, Operator>, element: String): Pair<Int, Operator> {
    if (Operator.contain(element)) {
        return accumulator.first to Operator.bySign(element)
    }

    val result = accumulator.second.apply(accumulator.first, element.toInt())
    return result to Operator.PLUS
}
