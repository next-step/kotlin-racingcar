package step2.domain

import step2.model.ErrorCode

object Calculator {

    fun calculate(inputString: String): Double {
        val calculatorInput = CalculatorInputConverter.convertToCalculatorInput(
            inputString = inputString,
        )

        val operators = calculatorInput.operators
        val numbers = calculatorInput.numbers

        var result = numbers.removeFirst()

        while (operators.isNotEmpty()) {
            val operator = operators.removeFirst()
            result = operator.calculate(firstNumber = result, secondNumber = numbers.removeFirst())
        }

        return result
    }
}

private object CalculatorInputConverter {

    private const val DELIMITERS = ' '
    private const val EVEN_START_INDEX = 0
    private const val ODD_START_INDEX = 1
    private const val STEP = 2

    @Throws(IllegalArgumentException::class)
    fun convertToCalculatorInput(inputString: String): CalculatorInput {
        val delimiterSplits = inputString.split(DELIMITERS)
        val size = delimiterSplits.size

        return CalculatorInput(
            numbers = (EVEN_START_INDEX until size step STEP).map {
                val numberString = delimiterSplits[it]

                requireNotNull(value = numberString.toDoubleOrNull()) {
                    ErrorCode.INVALID_NUMBER_INPUT.message(numberString)
                }
            }.run { ArrayDeque(elements = this) },

            operators = (ODD_START_INDEX until size step STEP).map {
                Operator.findByCommand(command = delimiterSplits[it])
            }.run { ArrayDeque(elements = this) },
        )
    }
}

private data class CalculatorInput(
    val numbers: ArrayDeque<Double>,
    val operators: ArrayDeque<Operator>,
) {

    init {
        val numberSize = numbers.size
        val operatorSize = operators.size

        require(value = numberSize == operatorSize + VALID_RANGE) {
            ErrorCode.INVALID_CALCULATOR_INPUT.message("$numberSize $operatorSize")
        }
    }

    companion object {
        private const val VALID_RANGE: Int = 1
    }
}
