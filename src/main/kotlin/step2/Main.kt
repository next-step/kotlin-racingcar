package step2

fun main() {

    val calculator = StringCalculator()
    val expression = readlnOrNull()
    val result = calculator.calculate(expression)

    println(result)
}