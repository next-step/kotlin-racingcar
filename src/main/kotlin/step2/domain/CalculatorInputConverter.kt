package step2.domain

import step2.model.ErrorCode

object CalculatorInputConverter {

    private const val DELIMITERS = ' '
    private const val EVEN_START_INDEX = 0
    private const val ODD_START_INDEX = 1
    private const val STEP = 2

    fun convertToCalculatorInput(inputString: String): CalculatorInput {
        val delimiterSplits = inputString.split(DELIMITERS)
        val size = delimiterSplits.size

        return CalculatorInput(
            numbers = (EVEN_START_INDEX until size step STEP).map {
                val numberString = delimiterSplits[it]

                requireNotNull(value = numberString.toLongOrNull()) {
                    ErrorCode.INVALID_NUMBER_INPUT.message(numberString)
                }
            }.run { ArrayDeque(elements = this) },

            operators = (ODD_START_INDEX until size step STEP).map {
                Operator.getOperatorByCommand(command = delimiterSplits[it])
            }.run { ArrayDeque(elements = this) },
        )
    }
}
