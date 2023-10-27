package calculator.model

class Arithmetic(
    private val operators: List<Operator>,
    private val operands: List<Operand>,
) {
    fun act(): Int {
        assertFormula(operators.size, operands.size)
        // return accumulatorV1()
        return accumulatorV2()
    }

    private fun accumulatorV1(): Int {
        var result = operands[0].value
        for (i in 0 until operators.size) {
            result = operators[i].operate(result, operands[i + 1].value)
        }
        return result
    }

    private fun accumulatorV2(): Int {
        val combinedList = operators.zip(
            operands.drop(1)
        ) { op, operand -> op to operand.value }
        val result = combinedList.fold(
            operands.first().value
        ) { acc, (op, value) ->
            op.operate(acc, value)
        }
        return result
    }

    private fun assertFormula(operatorsCount: Int, operandsCount: Int) {
        if (operatorsCount + 1 != operandsCount) {
            throw IllegalArgumentException("연산자와 피연산자의 숫자가 적합하지 않습니다. 피연산자 갯수 = 연산자갯수 + 1 이어야 합니다")
        }
    }
}
