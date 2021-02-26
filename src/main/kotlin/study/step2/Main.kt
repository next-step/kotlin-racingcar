package study.step2

fun main() {
    val splitExpressionList: List<String> = inputExpress()
}

private fun inputExpress(): List<String> {
    val input = InputConsole()
    return input.readExpression()
}
