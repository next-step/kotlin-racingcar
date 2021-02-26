package study.step2

fun main() {

    val splitExpressionList: List<String> = inputExpress()
    val result = calculateExpression(splitExpressionList)
    OutputConsole().outputResult(result)
}

private fun inputExpress(): List<String> {
    val input = InputConsole()
    return input.readExpression()
}

private fun calculateExpression(expression: List<String>): Int {
    return Calculator().calculateExpression(expression)
}
