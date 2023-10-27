package calculator

class Calculator(
    private val arithmeticOperation: ArithmeticOperation,
    private val calculatorValidator: CalculatorValidator,
) {

    fun calculateExpression(expression: String): Double {
        calculatorValidator.expressionValidate(expression)

        val tokens = expression.split(" ")
        var result = Number.ZERO
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
