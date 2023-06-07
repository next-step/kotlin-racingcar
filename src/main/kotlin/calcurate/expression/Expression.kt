package calcurate.expression

import calcurate.ErrorCode
import calcurate.factory.CalcStrategyFactory
import calcurate.strategy.CalcStrategy
import java.util.LinkedList
import java.util.Queue

data class Expression(val expression: String? = null) {
    private val numArray: List<Double>
    private val symbolArray: List<CalcStrategy>

    init {
        if (expression.isNullOrBlank()) throw IllegalArgumentException(ErrorCode.INVALID_EXPRESSION.msg)

        val expressionArray = expression.split(delimiter)
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
        val symbolQueue = convertListToQueue(symbolArray)
        return numArray.reduce { prev, next -> symbolQueue.poll().calc(prev, next) }
    }

    private inline fun <reified T> convertListToQueue(list: List<T>): Queue<T> {
        return LinkedList(list)
    }

    companion object {
        const val delimiter = " "
    }
}
