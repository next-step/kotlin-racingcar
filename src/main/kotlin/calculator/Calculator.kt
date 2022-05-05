package calculator

class Calculator(calculationParameter: CalculationParameter) {
    private val calculationParameter: CalculationParameter = calculationParameter

    constructor(stringExpression: String?) : this(CalculationParameter(stringExpression))

    fun getCalculationResult(): Double {
        var result: Double = calculationParameter.operands[0].toDouble()

        for ((index, operator) in calculationParameter.operators.withIndex()) {
            val rightOperand = calculationParameter.operands[index + 1]
            result = getValueByOperator(result, rightOperand.toDouble(), operator)
        }

        return result
    }

    private fun getValueByOperator(leftOperand: Double, rightOperand: Double, operator: Operator): Double {
        return when (operator) {
            Operator.PLUS -> leftOperand + rightOperand
            Operator.MINUS -> leftOperand - rightOperand
            Operator.MULTIPLICATION -> leftOperand * rightOperand
            Operator.DIVISION -> leftOperand / rightOperand
        }
    }
}
