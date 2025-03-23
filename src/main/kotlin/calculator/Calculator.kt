package calculator

import calculator.exceptions.NumberSeparationException
import calculator.exceptions.OperationBetweenNumbersException

object Calculator {
    fun calculate(inputList: List<String>): Double {
        var currentCalculation = 0.0
        var pendingNumber = 0.0

        for (index in inputList.indices) {
            if (index % 2 != 0) {
                // even element - number
                pendingNumber = processNumber(inputList[index])
            } else {
                // odd - operation
                val operation = processOperation(inputList[index])
                currentCalculation = performOperation(operation, currentCalculation, pendingNumber)
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
