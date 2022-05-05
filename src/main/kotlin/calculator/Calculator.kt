package calculator

class Calculator(calculationParameter: CalculationParameter) {
    private val calculationParameter: CalculationParameter = calculationParameter

    constructor(stringExpression: String?) : this(CalculationParameter(stringExpression))

    fun getCalculationResult(): Double {
        var result: Double = calculationParameter.factors[0].toDouble()

        for ((index, operator) in calculationParameter.operators.withIndex()) {
            val rightFactor = calculationParameter.factors[index + 1]
            result = getValueByOperator(result, rightFactor.toDouble(), operator)
        }

        return result
    }

    private fun getValueByOperator(leftFactor: Double, rightFactor: Double, operator: String): Double {
        when (operator) {
            "+" -> return leftFactor + rightFactor
            "-" -> return leftFactor - rightFactor
            "*" -> return leftFactor * rightFactor
            "/" -> return leftFactor / rightFactor
        }
        throw Error()
    }
}
