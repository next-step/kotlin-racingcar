package calculator

fun main() {
    println("식을 입력해주세요")

    val input: String? = readLine()
    val lexer = Lexer.new(input)
    val result = Parser.parse(lexer)

    println("결과: $result")
}
