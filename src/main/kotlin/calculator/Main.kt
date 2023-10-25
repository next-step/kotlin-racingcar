package calculator

fun main() {
    val input = readln()
    val calculator = Calculator(input.split(" "))
    println(calculator.calculate())
}
