package calculator

class Calculator(
    private val calculatorInputValidator: CalculatorInputValidator,
    private val calculatorInputParser: CalculatorInputParser,
) {
    fun calculate(input: String?): Double {
        calculatorInputValidator.validate(input)

        val parsedInput = calculatorInputParser.parse(input!!)
        val operands = parsedInput.operands
        val operators = parsedInput.operators

        var index = 0

        return operands.reduce { accumulator, number ->
            calculate(accumulator, operators[index++], number)
        }
    }

    private fun calculate(operand1: Double, operator: Operator, operand2: Double): Double {
        return when (operator) {
            Operator.PLUS -> operand1 + operand2
            Operator.MINUS -> operand1 - operand2
            Operator.MULTIPLY -> operand1 * operand2
            Operator.DIVIDE -> {
                throwIfDivideByZero(operand2)
                operand1 / operand2
            }
        }
    }

    private fun throwIfDivideByZero(divisor: Double) {
        if (divisor == 0.0) {
            throw ArithmeticException("Division by zero.")
        }
    }
}
