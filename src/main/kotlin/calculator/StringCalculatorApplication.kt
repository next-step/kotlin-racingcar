package calculator

fun main() {
    val calculator = StringCalculator()

    val input = readlnOrNull()
    val expression = StringExpression(input)
    val result = calculator.calculate(expression)

    println(result)
}
