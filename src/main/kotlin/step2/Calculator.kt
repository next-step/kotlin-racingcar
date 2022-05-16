package step2

object Calculator {
    const val blankErrorMessage = "입력값이 없습니다"
    private const val symbolErrorMessage = "지원하지 않는 연산자"
    fun calculate(string: String): Double {
        if (string.isBlank()) {
            throw IllegalArgumentException(blankErrorMessage)
        }
        val numbersWithOperatorSymbols: List<String> = StringParser.listByOperatorSymbol(string)
        val first = StringParser.toDouble(numbersWithOperatorSymbols.first())
        var result = first
        for (i in 1 until numbersWithOperatorSymbols.size step 2) {
            val operate: (Double, Double) -> Double = when (numbersWithOperatorSymbols[i]) {
                "+" -> Operator.PLUS.operate
                "-" -> Operator.SUBTRACT.operate
                "*" -> Operator.MULTIPLY.operate
                "/" -> Operator.DIVISION.operate
                // StringParser.listByOperatorSymbol 가 정상 동작한다면 아래 에러는 발생하지 않음
                else -> throw IllegalAccessError(symbolErrorMessage)
            }
            val number = StringParser.toDouble(numbersWithOperatorSymbols[i + 1])
            result = operate(result, number)
        }
        return result
    }
}
