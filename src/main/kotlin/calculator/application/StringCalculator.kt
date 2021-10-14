package calculator.application

import calculator.domain.Calculator
import calculator.domain.Expression
import calculator.domain.operator.Operator
import calculator.exception.OperatorNotFoundException

class StringCalculator(
    private val calculators: List<Calculator>,
) {

    companion object {
        private const val START = 1
        private const val NUMBER_ONE = 1
        private const val INCREASE = 2
    }

    private val calculatorMap: Map<Operator, Calculator> by lazy {
        calculators.associateBy {
            it.operator
        }.also {
            if (it.isEmpty()) {
                throw IllegalStateException()
            }
        }
    }

    fun execute(expression: String?): Int {
        val segregatedExpressions = Expression(expression).segregateExpressions()
        var result = segregatedExpressions.first().toInt()

        for (i in START until segregatedExpressions.size step (INCREASE)) {
            val operator: String = segregatedExpressions[i]
            val second = segregatedExpressions[i + NUMBER_ONE].toInt()

            result = calculate(operator, result, second)
        }
        return result
    }

    private fun calculate(operator: Operator, first: Int, second: Int): Int {
        val calculator = calculatorMap[operator] ?: throw OperatorNotFoundException()
        return calculator.calculate(first, second)
    }
}
