package calculator

fun main() {
    println("식을 입력해주세요")

    val input: String? = readLine()
    requireNotNull(input) { "식을 입력해주세요" }
    val lexer = Lexer.from(input)
    val result = Calculator.calculate(lexer)

    println("결과: $result")
}
