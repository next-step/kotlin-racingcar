package calculator

import calculator.exception.IllegalExpressionException

class Expression(
    private val numbers: List<Float>,
    private val operators: List<Operator>
) {

    init {
        validate()
    }

    fun sum(): Float {
        return numbers.reduceIndexed { index, acc, s ->
            operators[index - 1].calculate(acc, s)
        }
    }

    private fun validate() {
        if (numbers.size != operators.size + 1) {
            throw IllegalExpressionException("숫자는 기호보다 1개 많아야 합니다.")
        }
    }
}
