package calculator

fun main() {

    val calculator = Calculator()
    // 2 + 3 * 4 / 2
    println("식을 입력하세요.")
    val expression = readLine()!!

    val result = calculator.calculate(expression)
    println(result)

}