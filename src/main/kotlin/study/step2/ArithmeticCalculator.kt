package study.step2

import study.step2.Operator.ADD
import study.step2.Operator.DIV
import study.step2.Operator.MUL
import study.step2.Operator.NONE
import study.step2.Operator.SUB

class ArithmeticCalculator {

    private fun add(operand1: Int, operand2: Int) = operand1 + operand2
    private fun sub(operand1: Int, operand2: Int) = operand1 - operand2
    private fun mul(operand1: Int, operand2: Int) = operand1 * operand2
    private fun div(operand1: Int, operand2: Int) = operand1 / operand2

    fun calculate(input: String?): Int {
        requireNotNull(input)
        require(input.isNotEmpty())

        var result = 0
        var operator = NONE

        input.split(" ").forEach {
            it.toIntOrNull()?.let { operand ->
                result = operate(operator, operand, result)
            } ?: run {
                operator = setOperator(it)
            }
        }

        return result
    }

    private fun operate(
        inputOperator: Operator,
        operand: Int,
        result: Int
    ) = when (inputOperator) {
        ADD -> add(result, operand)
        SUB -> sub(result, operand)
        MUL -> mul(result, operand)
        DIV -> div(result, operand)
        NONE -> operand
    }

    private fun setOperator(inputOperator: String) =
        when (inputOperator) {
            "+" -> ADD
            "-" -> SUB
            "*" -> MUL
            "/" -> DIV
            else -> NONE
        }
}
