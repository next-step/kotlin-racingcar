package study.step2

import java.lang.IllegalArgumentException

class CalculationFactory {
    companion object {
        fun create(operator: String): Calculation = when (operator) {
            "+" -> Addition()
            "-" -> Subtraction()
            "*" -> Multiplication()
            "/" -> Division()
            else -> throw IllegalArgumentException("지원하는 연산자가 아닙니다.")
        }
    }
}
