package calculator

fun main() {

    val calculator = Calculator()
    println("식을 입력하세요.")

    val expression = readln()
    val result = calculator.calculate(expression)
    println(result)
}
