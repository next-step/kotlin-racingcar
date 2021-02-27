package calculator.domain

import java.lang.IllegalArgumentException

class Calculator(private val operands: List<Number>, private val operators: List<Operator>) {

    init {
        validate(operands, operators)
    }

    fun calculate(): Number {
        val mutableOperands = operands.toMutableList()
        val mutableOperators = operators.toMutableList()

        var result = mutableOperands.removeAt(0)

        while (mutableOperands.isNotEmpty()) {
            val operator = mutableOperators.removeAt(0)
            result = operator.operate(result, mutableOperands.removeAt(0))
        }

        return result
    }

    private fun validate(operands: List<Number>, operators: List<Operator>) {
        if (operands.size != operators.size + 1) {
            throw IllegalArgumentException("숫자는 연산자보다 갯수가 1개 더 많아야 합니다")
        }
    }
}
