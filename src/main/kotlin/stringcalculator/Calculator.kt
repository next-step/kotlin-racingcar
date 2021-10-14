package stringcalculator

import stringcalculator.operations.Operation

class Calculator(private val inputValidator: InputValidator, private val inputConverter: InputConverter) {
    fun calculate(input: String?): Int {
        val validatedInput = validateInput(input)
        val inputDeque = extractNumbers(validatedInput)
        val operations = convertToOperations(validatedInput)
        return executeOperations(inputDeque, operations)
    }

    private fun validateInput(input: String?): List<String> {
        return inputValidator.validate(input)
    }

    private fun extractNumbers(splitString: List<String>): ArrayDeque<Int> {
        return inputConverter.extractInts(splitString)
    }

    private fun convertToOperations(splitString: List<String>): List<Operation> {
        return inputConverter.convertToOperations(splitString)
    }

    private fun executeOperations(inputDeque: ArrayDeque<Int>, operations: List<Operation>): Int {
        for (operation in operations) {
            operation.execute(inputDeque)
        }

        return inputDeque.first()
    }
}
