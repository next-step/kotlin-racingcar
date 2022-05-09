package operator.application

import operator.domain.Calculator

class OperatorService(private val calculator: Calculator) {

    fun operator(input: String): Double {
        if (!input.last().isDigit()) {
            throw IllegalArgumentException("잘못된 인풋값 입니다.")
        }

        return calculator.calculate(input)
    }
}
