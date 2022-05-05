package calculator

fun main() {
    val stringCalculator = StringCalculator(ExpressionFactory(OneSpaceSeparationStrategy()))
    val readText = readExpressionText()
    print(stringCalculator, readText)
}

private fun readExpressionText(): String {
    println("수식을 입력해주세요.")
    return readln()
}

private fun print(stringCalculator: StringCalculator, readText: String) {
    val result = stringCalculator.calculate(readText)
    println("계산 결과: $result")
}
