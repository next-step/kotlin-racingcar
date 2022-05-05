package calculator

class Calculator(calculationParam: CalculationParameter) {
    private val calculationParameter = calculationParam

    constructor(stringExpression: String?) : this(CalculationParameter(stringExpression))

    fun calculation(): Double {
        var result: Double = calculationParameter.operands[0].toDouble()

        for ((index, operator) in calculationParameter.operators.withIndex()) {
            val rightOperand = calculationParameter.operands[index + 1]
            result = calculationByOperator(result, rightOperand.toDouble(), operator)
        }

        return result
    }

    private fun calculationByOperator(leftOperand: Double, rightOperand: Double, operator: Operator): Double {
        return when (operator) {
            Operator.PLUS -> leftOperand + rightOperand
            Operator.MINUS -> leftOperand - rightOperand
            Operator.MULTIPLICATION -> leftOperand * rightOperand
            Operator.DIVISION -> leftOperand / rightOperand
        }
    }
}
