package calculator

import util.isEven
import util.isOdd

internal object CalculatorInputGenerator {
    private const val DELIMITER = " "

    fun generate(input: String?): CalculatorInput {
        require(!input.isNullOrBlank()) { "Input should not be null or blank." }

        val splitInput = input.split(DELIMITER)

        return CalculatorInput(
            operands = generateOperands(splitInput),
            operators = generateOperators(splitInput),
        )
    }

    private fun generateOperands(splitInput: List<String>): List<Double> {
        return splitInput.filterIndexed { index, _ -> index.isEven() }
            .map { it.toDouble() }
    }

    private fun generateOperators(splitInput: List<String>): List<Operator> {
        return splitInput.filterIndexed { index, _ -> index.isOdd() }
            .map {
                require(Operator.isFourBasicOperations(it)) {
                    "Input can only contain four basic operators. Input operator: $it."
                }
                Operator.fromSymbol(it)
            }
    }
}
