package calculator

fun main() {
    val rawExpression: String? = readlnOrNull()
    require(!rawExpression.isNullOrBlank()) { "입력값이 없거나 공백 문자입니다." }

    val result = Calculator.execute(rawExpression)

    println("결과 값 : $result")
}
