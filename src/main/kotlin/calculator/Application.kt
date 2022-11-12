package calculator

class Application

fun main() {
    val expression = Expression(readln())
    val calculator = Calculator(Parser())

    println(calculator.calculate(expression))
}
