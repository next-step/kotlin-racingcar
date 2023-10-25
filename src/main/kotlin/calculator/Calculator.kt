package calculator

fun calculate(expression: String?): Int {
    val symbols = checkNullOrBlank(expression).split(" ")
    var result = symbols[0].toInt()

    for (i in 1 until symbols.size step 2) {
        val operator = symbols[i].findOperator()
        val number = symbols[i + 1].toInt()
        result = operator.apply(result, number)
    }

    return result
}
