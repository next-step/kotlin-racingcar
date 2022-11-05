package calculator

object Calculator {
    fun calculate(rawString: String?): Double {
        val tokenizeData = Parser.parse(rawString)
        return tokenizeData.calculate()
    }
}
