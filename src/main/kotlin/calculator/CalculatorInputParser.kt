package calculator

import util.isEven
import util.isOdd

class CalculatorInputParser {
    fun parse(input: String): CalculatorInputParseResult {
        return CalculatorInputParseResult(
            operands = parseOperands(input),
            operators = parseOperators(input),
        ).also {
            validateParsedInputResult(it)
        }
    }

    private fun parseOperands(input: String): List<Double> {
        return input.split(DELIMITER)
            .filterIndexed { index, _ ->
                index.isEven()
            }
            .map {
                it.toDouble()
            }
    }

    private fun parseOperators(input: String): List<Operator> {
        return input.split(DELIMITER)
            .filterIndexed { index, _ ->
                index.isOdd()
            }
            .map {
                validateIsFourBasicOperations(it)
                Operator.fromSymbol(it)
            }
    }

    private fun validateIsFourBasicOperations(operator: String) {
        val fourBasicOperators = Operator.getFourBasicOperators()
            .map { it.symbol }

        if (operator !in fourBasicOperators) {
            throw IllegalArgumentException("Input can only contain four basic operators. Input operator: $operator.")
        }
    }

    private fun validateParsedInputResult(result: CalculatorInputParseResult) {
        if (result.operands.size != result.operators.size + 1) {
            throw IllegalArgumentException("Number of operands should be one more than number of operators.")
        }
    }

    companion object {
        private const val DELIMITER = " "
    }
}

data class CalculatorInputParseResult(
    val operands: List<Double>,
    val operators: List<Operator>,
)
