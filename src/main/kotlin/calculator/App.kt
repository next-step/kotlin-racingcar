package calculator

fun main() {
    val readText = readExpressionText()
    val calculatedNumber = Calculator.calculate(Expression.of(readText))
    printResult(calculatedNumber)
}

private fun readExpressionText(): String {
    println("수식을 입력해주세요.")
    return readln()
}

private fun printResult(result: Int) {
    println("계산 결과: $result")
}
