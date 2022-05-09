package calculator

fun main() {
    print("사칙연산 입력값 : ")
    val input = readln()

    val result = StringCalculator(ArithmeticExpression(input)).calculate()

    println("결과 : $result")
}
