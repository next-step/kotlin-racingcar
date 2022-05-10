package calculator

fun main() {
    val value = readLine()

    val expressions = StringCalculator(value)
        .getValues()

    println(Expression(expressions).calculate())
}
