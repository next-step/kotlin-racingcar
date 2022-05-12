package calculator

fun main() {
    println("사칙 연산을 수행할 문자열 값을 입력해주세요.")

    val inputString = readLine()
    val calculator = Calculator(inputString)
    val result = calculator.calculate()

    println(result.value)
}
