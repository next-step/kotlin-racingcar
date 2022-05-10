package calculator

fun main() {
    val value = readLine()

    val expressions = CustomStringDelimiter(value)
        .getValues()

    println(Expression(expressions).calculate())
}
