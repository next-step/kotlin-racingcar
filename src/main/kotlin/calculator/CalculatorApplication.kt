package calculator

fun main() {
    val calculator = Calculator()
    println("사칙 연산을 수행할 문자열 값을 입력해주세요.")
    val result = calculator.calculate(readln())

    println(result.value)
}
