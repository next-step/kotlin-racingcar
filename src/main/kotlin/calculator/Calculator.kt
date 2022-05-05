package calculator

import java.lang.Integer.parseInt

val OPERATOR_REGEX = Regex("([+-/*])")

class Calculator {
    private var operators: List<String> = emptyList<String>()
    private var factors: List<Int> = emptyList<Int>()

    constructor(arithmeticExpression: String?) {
        if (arithmeticExpression == null) throw Error()

        operators = OPERATOR_REGEX.findAll(arithmeticExpression).map {
            it.groupValues[0]
        }.toList()

        factors = OPERATOR_REGEX.split(arithmeticExpression).map {
            parseInt(it.replace(Regex("\\s"), ""))
        }
    }

    fun getCalculationResult(): Double {
        var result: Double = factors[0].toDouble()

        for ((index, operator) in operators.withIndex()) {
            val rightFactor = factors[index + 1]
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
