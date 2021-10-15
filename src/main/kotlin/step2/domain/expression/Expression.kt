package step2.domain.expression

data class Expression(private val expression: String) {
    init {
        require(expression.isNotBlank()) { IllegalArgumentException(NULL_OR_BLANK_MESSAGE) }
    }

    companion object {
        private const val NULL_OR_BLANK_MESSAGE = "연산식이 null 또는 공백입니다."
    }
}
