package calculator.application

import calculator.domain.Calculator
import calculator.domain.operator.Operator
import calculator.exception.OperatorNotFoundException

class StringCalculator(
    private val calculators: List<Calculator>,
) {

    private val calculatorMap: Map<Operator, Calculator> by lazy {
        calculators.associateBy {
            it.operator
        }.also {
            if (it.isEmpty()) {
                throw IllegalStateException()
            }
        }
    }

    private fun findOperator(operator: Operator): Calculator {
        return calculatorMap[operator] ?: throw OperatorNotFoundException()
    }
}
