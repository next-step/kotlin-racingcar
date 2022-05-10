package step2

class Calculator {

    fun calculate(input: String): Double {
        val inputs = input.split(DELIMITER)
        var result = inputs[FIRST_NUMBER_POSITION].toDouble()
        for (operationIndex in FIRST_OPERATION until inputs.size step NEXT_OPERATION_STEP) {
            val operation = Operator.of(inputs[operationIndex].first())
            result = operation.operate(result, inputs[operationIndex + NEXT_NUMBER_POSITION].toDouble())
        }

        return result
    }

    companion object {
        private const val DELIMITER = " "
        private const val FIRST_OPERATION = 1
        private const val NEXT_OPERATION_STEP = 2
        private const val NEXT_NUMBER_POSITION = 1
        private const val FIRST_NUMBER_POSITION = 0
    }
}
