package stringcalculator

class Calculator(private val inputValidator: InputValidator, private val inputConverter: InputConverter) {
    fun calculate(input: String?): Int {
        val validatedInput = validateInput(input)
        val numbers = extractNumbers(validatedInput)
        val operations = convertToOperators(validatedInput)
        return executeOperations(numbers, operations)
    }

    private fun validateInput(input: String?): List<String> {
        return inputValidator.validate(input)
    }

    private fun extractNumbers(splitString: List<String>): List<Int> {
        return inputConverter.extractInts(splitString)
    }

    private fun convertToOperators(splitString: List<String>): List<Operator> {
        return inputConverter.convertToOperators(splitString)
    }

    private fun executeOperations(numbers: List<Int>, operators: List<Operator>): Int {
        var calculated = numbers.first()
        val rest = numbers.slice(1 until numbers.size)
        for (i in operators.indices) {
            calculated = operators[i].execute(calculated, rest[i])
        }
        return calculated
    }
}
