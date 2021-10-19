package calculator

fun main() {
    val expression = ConsoleInputView.getExpression()
    val result = Calculator.evaluate(expression)
    ConsoleOutputView.printResult(result)
}
