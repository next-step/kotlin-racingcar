package calculator

fun main() {
    val expression: String = Reader().readExpression()
    val result: Int = Calculator().execute(expression)

    println("결과: $result")
}
