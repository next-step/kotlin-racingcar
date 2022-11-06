package calculator

class Application

fun main(args: Array<String>) {
    val input = Input(readlnOrNull())
    val calculator = Calculator(Parser())

    println(calculator.calculate(input))
}
