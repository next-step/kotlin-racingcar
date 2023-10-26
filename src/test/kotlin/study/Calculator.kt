package study

class Calculator(private val input: String?) {
    fun calculate(): Double {
        val inputValues = input?.split(" ") ?: throw IllegalArgumentException("입력값이 null 입니다.")

        checkInputValid(inputValues)

        var current = runCatching { inputValues[0].toDouble() }.getOrElse { throw IllegalArgumentException() }
        var arithMeticSymbol: ArithMeticSymbol = ArithMeticSymbol.NONE
        for (inputValue in inputValues.slice(1 until inputValues.size)) {
            if (inputValue.isNumeric()) {
                current = arithMeticSymbol.calculate.invoke(current, inputValue.toDouble())
                continue
            }
            arithMeticSymbol = ArithMeticSymbol.of(inputValue)
        }
        return current
    }

    private fun checkInputValid(inputValues: List<String>) {
        if (inputValues.size < 3) {
            throw IllegalArgumentException()
        }
    }
}

private enum class ArithMeticSymbol(val symbol: String, val calculate: (Double, Double) -> Double) {
    PLUS("+", fun(value1: Double, value2: Double) = value1 + value2),
    MINUS("-", fun(value1: Double, value2: Double) = value1 - value2),
    DIVIDE("/", fun(value1: Double, value2: Double) = value1 / value2),
    MULTIPLY("*", fun(value1: Double, value2: Double) = value1 * value2),
    NONE("", fun(_: Double, _: Double) = 0.0)
    ;

    companion object {
        fun of(symbol: String): ArithMeticSymbol {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException()
        }
    }
}

private fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}
