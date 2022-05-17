package step2

object Calculator {
    const val blankErrorMessage = "입력값이 없습니다"
    fun calculate(string: String): Double {
        if (string.isBlank()) {
            throw IllegalArgumentException(blankErrorMessage)
        }
        val numbersWithOperatorSymbols: List<String> = StringParser.listByOperatorSymbol(string)
        val first = StringParser.toDouble(numbersWithOperatorSymbols.first())
        var result = first
        for (i in 1 until numbersWithOperatorSymbols.size step 2) {
            val operator = Operator.operatorBy(numbersWithOperatorSymbols[i])
            val number = StringParser.toDouble(numbersWithOperatorSymbols[i + 1])
            result = operator(result, number)
        }
        return result
    }
}
