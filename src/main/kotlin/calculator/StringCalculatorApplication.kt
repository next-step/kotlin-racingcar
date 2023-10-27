package calculator

fun main() {
    val input = readlnOrNull()
    val expression = StringExpression(input)
    val result = StringCalculator.calculate(expression)

    println(result)
}
