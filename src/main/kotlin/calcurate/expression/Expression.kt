package calcurate.expression

import calcurate.ErrorCode
import calcurate.factory.CalcStrategyFactory
import calcurate.strategy.CalcStrategy

data class Expression(val expression: String? = null) {
    private val numArray: List<Double>
    private val symbolArray: List<CalcStrategy>

    init {
        if (expression.isNullOrBlank()) throw IllegalArgumentException(ErrorCode.INVALID_EXPRESSION.msg)

        val expressionArray = expression.split(DELIMITER)
        with(expressionArray) {
            numArray = this
                .filterIndexed { index, _ -> index % 2 == 0 }
                .map { it.toDouble() }

            symbolArray = this
                .filterIndexed { index, _ -> index % 2 != 0 }
                .map { CalcStrategyFactory.selectCalcStrategy(it) }
        }
    }

    fun calculation(): Double {
        val symbolList = symbolArray.toMutableList()
        return numArray.reduce { prev, next -> symbolList.removeFirst().calc(prev, next) }
    }

    companion object {
        private const val DELIMITER = " "
    }
}
