package calculator

enum class Operation(val value: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"), ;

    companion object {
        val VALID_NUMBER_PATTERN = "^-?\\d+( [+\\-*/] -?\\d+)+\$".toRegex()
        fun fromString(element: String): Operation = values().find { it.value == element }
            ?: throw IllegalArgumentException(ErrorMessage.UNSUPPORTED_OPERATOR_MSG.message)
    }

    fun calculate(currentResult: Int, nextValue: Int): Int {
        return when (this) {
            PLUS -> currentResult.plus(nextValue)
            MINUS -> currentResult.minus(nextValue)
            MULTIPLY -> currentResult.times(nextValue)
            DIVIDE -> currentResult.div(nextValue)
        }
    }
}
