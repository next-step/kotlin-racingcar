package calculator.domain

import calculator.domain.operator.Operator
import calculator.domain.operator.Operators

class DivisionCalculator : Calculator {
    override val operator: Operator = Operators.DIVISION

    companion object {
        private const val ZERO = 0
        private const val VALIDATION_MESSAGE = "0으로 나눌 수 없습니다. 다시 입력해주세요."
    }

    override fun calculate(first: Int, second: Int): Int {
        if (second == ZERO) {
            throw IllegalArgumentException(VALIDATION_MESSAGE)
        }
        return first.div(second)
    }
}
