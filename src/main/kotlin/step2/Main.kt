package step2

fun main() {

    val expression = readlnOrNull()
    val result = StringCalculator.calculate(expression)
    println(result)
}