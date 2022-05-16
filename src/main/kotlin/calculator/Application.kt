package calculator

fun main() {
    println("계산식 문자열을 입력하세요")
    val input = readLine()
    StringCalculator(input).run()
}
