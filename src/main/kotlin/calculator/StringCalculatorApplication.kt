package calculator

fun main() {
    val input = readlnOrNull()
    val result = StringCalculator.calculate(input)

    println(result)
}
