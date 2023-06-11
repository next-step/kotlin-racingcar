package calculator

fun calculateFromString(expression: String): Int {
    val expressionQueue = buildExpressionQueue(expression.replace(" ", ""))
    var result = 0
    var operator = '+'
    while (!expressionQueue.isEmpty()) {
        val element = expressionQueue.poll()
        if (element is Int) {
            result = Calculator(result, operator, element).calcuate()
        } else if (element is Char) {
            operator = element
        }
    }

    return result
}
