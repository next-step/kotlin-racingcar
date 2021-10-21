package calculator.domain

import calculator.domain.Operator.Companion.isOperator

class StringCalculator {

    fun execute(input: String?): Double {
        return calculate(Expression.validate(input))
    }

    private fun calculate(input: String): Double {
        val (_operators, _operands) = input.split(" ")
            .partition { isOperator(it) }

        val operators = _operators.toOperators()
        val operands = _operands.toOperands()

        var result = operands.first().value
        for (index in 1 until operands.size) {
            result = Expression(result.toOperand(), operands[index], operators[index - 1]).calculate()
        }

        return result
    }

    private fun List<String>.toOperators() = this.map { Operator.of(it) }
    private fun List<String>.toOperands() = this.map { Operand(it) }
    private fun Double.toOperand() = Operand(this.toString())
}
