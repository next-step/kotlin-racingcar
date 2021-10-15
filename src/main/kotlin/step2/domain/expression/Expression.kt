package step2.domain.expression

import step2.strategy.split.SplitStrategy

data class Expression(private val expression: String?) {
    init {
        require(!expression.isNullOrBlank()) { IllegalArgumentException(NULL_OR_BLANK_MESSAGE) }
    }

    fun split(strategy: SplitStrategy) = strategy.split(expression!!)

    companion object {
        private const val NULL_OR_BLANK_MESSAGE = "연산식이 null 또는 공백입니다."
    }
}
