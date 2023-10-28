package stringcalculator

data class Calculator(
    var number: Int = DEFAULT_VALUE,
    var operator: Operator? = null,
    var result: Int = DEFAULT_VALUE,
) {
    fun calculate() {
        when (operator) {
            Operator.PLUS -> result + number
            Operator.MINUS -> result - number
            Operator.MULTIPLY -> result * number
            Operator.DIVIDE -> result / number
            else -> number
        }.also {
            result = it
        }
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}
