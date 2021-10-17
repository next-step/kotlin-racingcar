package calculator

fun main() {
    val expression = IO.getExpression()
    val result = Calculator.evaluate(expression)
    IO.printResult(result)
}
