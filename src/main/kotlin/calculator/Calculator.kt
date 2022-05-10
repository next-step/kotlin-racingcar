package calculator

import calculator.ErrorMessage.Companion.CALCULATION_VALUE_IS_INFINITY

class Calculator(calculationParam: CalculationParameter) {
    private val calculationParameter = calculationParam

    constructor(stringExpression: String) : this(CalculationParameter(stringExpression))

    fun calculation(): Double {
        var result: Double = calculationParameter.operands[0].toDouble()

        for ((index, operator) in calculationParameter.operators.withIndex()) {
            val rightOperand = calculationParameter.operands[index + 1]
            result = calculationByOperator(result, rightOperand.toDouble(), operator)
            if(result.isInfinite()) throw IllegalArgumentException(CALCULATION_VALUE_IS_INFINITY)
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
