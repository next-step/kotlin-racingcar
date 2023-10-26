package calculator

class Calculator(
    private val arithmeticOperation: ArithmeticOperation,
    private val calculatorValidator: CalculatorValidator,
) {
    companion object {
        const val INITIAL_VALUE = 0.0
    }

    fun calculateExpression(expression: String): Double {
        calculatorValidator.expressionValidate(expression)

        val tokens = expression.split(" ")
        var result = INITIAL_VALUE
        var currentOperator: (Double, Double) -> Double = arithmeticOperation::addition

        tokens.forEach { token ->
            token.toDoubleOrNull()?.let { operand ->
                result = currentOperator(result, operand)
                return@forEach
            }

            calculatorValidator.validateOperator(token)
            currentOperator = getOperator(token)
        }

        return result
    }

    private fun getOperator(token: String): (Double, Double) -> Double {
        return when (Operator.findSymbol(token)) {
            Operator.ADDITION -> arithmeticOperation::addition
            Operator.SUBTRACTION -> arithmeticOperation::subtraction
            Operator.MULTIPLICATION -> arithmeticOperation::multiplication
            Operator.DIVISION -> arithmeticOperation::division
        }
    }
}
