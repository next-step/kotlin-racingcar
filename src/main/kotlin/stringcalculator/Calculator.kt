package stringcalculator

data class Calculator(
    var number: Int = 0,
    var operator: Operator? = null,
    var result: Int = 0,
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
}