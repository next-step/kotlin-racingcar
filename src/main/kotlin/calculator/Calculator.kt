package calculator

import calculator.util.toDoubleOrThrow
import calculator.util.toOperatorOrThrow

class Calculator(var number: Double) {
    fun execute(splitFormula: List<String>): Double {
        val initialValue = parseNumber(splitFormula.first())

        val formulaChunks = splitFormula.drop(FIRST_NUMBER_INDEX).chunked(NUMBER_AND_OPERATOR_PAIR_SIZE)

        return formulaChunks.fold(initialValue) { currentResult, (operator, operand) ->
            val number = parseNumber(operand)
            val symbol = parseOperator(operator)
            symbol.calculate(currentResult, number)
        }
    }

    fun parseNumber(value: String): Double {
        return value.toDoubleOrThrow()
    }

    fun parseOperator(value: String): Operator {
        return value.toOperatorOrThrow()
    }

    companion object {
        private const val FIRST_NUMBER_INDEX = 1
        private const val NUMBER_AND_OPERATOR_PAIR_SIZE = 2
    }
}
