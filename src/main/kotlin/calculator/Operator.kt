package calculator

enum class Operator(private val symbol: String, val operation: (Double, Double) -> Double) {
    PLUS(symbol = "+", operation = { a, b -> a + b }),
    MINUS(symbol = "-", operation = { a, b -> a - b }),
    MULTIPLE(symbol = "*", operation = { a, b -> a * b }),
    DIVIDE(symbol = "/", operation = { a, b -> a / b });
}

fun getOperator(operator: String): Operator {
    if (operator == "+") return Operator.PLUS
    if (operator == "-") return Operator.MINUS
    if (operator == "*") return Operator.MULTIPLE
    if (operator == "/") return Operator.DIVIDE
    return Operator.DIVIDE
}
