package calculator

class BasicOperationsCalculator {
    fun operation(a: Double, b: Double, symbol: String): Double {
        val operator = Operator.fromSymbol(symbol)
        return operator.operate(a, b)
    }
}
