package calculator

object Calculator {
    fun calculate(rawString: String?): Double {
        val expression: Expression = Parser.parse(rawString)
        return expression.calculate()
    }
}
