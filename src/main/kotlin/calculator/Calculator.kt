package calculator

import calculator.exceptions.NumberSeparationException
import calculator.exceptions.OperationBetweenNumbersException

object Calculator {
    fun calculate(input: String?) = calculate(InputParser.validateInput(input))

    private fun calculate(inputList: List<String>): Double {
        var currentCalculation = processNumber(inputList.first())
        var pendingOperation: Operation? = null

        for (index in 1..inputList.lastIndex) {
            if (index % 2 == 0) {
                // even element - number
                val number = processNumber(inputList[index])
                currentCalculation =
                    performOperation(
                        operation = requireNotNull(pendingOperation) { "Operation is required on this step" },
                        a = currentCalculation,
                        b = number,
                    )
            } else {
                // odd - operation
                pendingOperation = processOperation(inputList[index])
            }
        }

        return currentCalculation
    }

    private fun performOperation(
        operation: Operation,
        a: Double,
        b: Double,
    ): Double =
        when (operation) {
            Operation.ADD -> a + b
            Operation.SUBTRACT -> a - b
            Operation.MULTIPLY -> a * b
            Operation.DIVIDE -> a / b
        }

    private fun processNumber(inputNumber: String): Double = inputNumber.toDoubleOrNull() ?: throw OperationBetweenNumbersException()

    private fun processOperation(inputOperation: String): Operation =
        Operation.entries.firstOrNull { it.sign == inputOperation }
            ?: throw NumberSeparationException()

    private enum class Operation(
        val sign: String,
    ) {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
    }
}
