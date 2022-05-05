package calculator

fun main() {
    val stringCalculator = StringCalculator(ExpressionFactory(OneSpaceSeparationStrategy()))

    // 입력
    println("수식을 입력해주세요.")
    val readText = readln()

    // 출력
    val result = stringCalculator.calculate(readText)
    println("계산 결과: $result")
}
