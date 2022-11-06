package calculator

class Application

fun main(args: Array<String>) {
    val input = Input("2 + 3 * 4 / 2")
    val calculator = Calculator(Parser())

    println(calculator.calculate(input))
}
