package step2

import step2.util.toDoubleOrThrow
import step2.util.toOperatorOrThrow

class Calculator(var number: Double) {
    fun execute(splitFormula: List<String>): Double {
        val initialValue = parseNumber(splitFormula.first())

        val skipCount = 1
        val chunkSize = 2
        val formulaChunks = splitFormula.drop(skipCount).chunked(chunkSize)

        return formulaChunks.fold(initialValue) { currentResult, (operator, operand) ->
            val parsedOperand = parseNumber(operand)
            val parsedOperator = parseOperator(operator)
            calculate(currentResult, parsedOperand, parsedOperator)
        }
    }

    fun parseNumber(value: String): Double {
        return value.toDoubleOrThrow()
    }

    fun parseOperator(value: String): OperatorType {
        return value.toOperatorOrThrow()
    }

    fun calculate(
        currentResult: Double,
        number: Double,
        operator: OperatorType,
    ): Double {
        return when (operator) {
            OperatorType.ADD -> add(currentResult, number)
            OperatorType.SUBTRACT -> subtract(currentResult, number)
            OperatorType.MULTIPLY -> multiply(currentResult, number)
            OperatorType.DIVIDE -> divide(currentResult, number)
        }
    }

    private fun add(
        a: Double,
        b: Double,
    ): Double {
        return a + b
    }

    private fun subtract(
        a: Double,
        b: Double,
    ): Double {
        return a - b
    }

    private fun multiply(
        a: Double,
        b: Double,
    ): Double {
        return a * b
    }

    private fun divide(
        a: Double,
        b: Double,
    ): Double {
        if (b == 0.0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다")
        }
        return a / b
    }
}
