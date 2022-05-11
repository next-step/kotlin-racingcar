package operator.application

import operator.domain.Calculator

class OperatorService(private val calculator: Calculator) {

    fun operator(input: String): Double {
        require(input.isNotEmpty()) {
            "잘못된 인풋값 입니다."
        }

        return calculator.calculate(input)
    }
}
