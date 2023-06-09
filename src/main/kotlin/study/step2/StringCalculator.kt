package study.step2

class StringCalculator {

    private fun add(operand1: Int, operand2: Int) = operand1 + operand2
    private fun sub(operand1: Int, operand2: Int) = operand1 - operand2
    private fun mul(operand1: Int, operand2: Int) = operand1 * operand2
    private fun div(operand1: Int, operand2: Int) = operand1 / operand2

    fun calculate(input: String?): Int {
        requireNotNull(input)
        check(input.isNotEmpty())

        var result = 0
        var operator = OPERATOR.NONE

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
        inputOperator: OPERATOR,
        operand: Int,
        result: Int
    ) = when (inputOperator) {
        OPERATOR.ADD -> add(result, operand)
        OPERATOR.SUB -> sub(result, operand)
        OPERATOR.MUL -> mul(result, operand)
        OPERATOR.DIV -> div(result, operand)
        OPERATOR.NONE -> operand
    }

    private fun setOperator(inputOperator: String) =
        when (inputOperator) {
            "+" -> OPERATOR.ADD
            "-" -> OPERATOR.SUB
            "*" -> OPERATOR.MUL
            "/" -> OPERATOR.DIV
            else -> OPERATOR.NONE
        }
}

enum class OPERATOR {
    NONE, ADD, SUB, MUL, DIV
}
