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

    private fun extractNumbers(splitString: List<String>): MutableList<Int> {
        return inputConverter.extractInts(splitString)
    }

    private fun convertToOperators(splitString: List<String>): List<Operator> {
        return inputConverter.convertToOperators(splitString)
    }

    private fun executeOperations(numbers: MutableList<Int>, operators: List<Operator>): Int {
        for (operator in operators) {
            val operational = popLastTwo(numbers)
            val result = operator.execute(operational)
            numbers.add(result)
        }

        return numbers.first()
    }

    @Throws(NoSuchElementException::class)
    private fun popLastTwo(numbers: MutableList<Int>): Operational {
        val leftNum = numbers.removeLast()
        val rightNum = numbers.removeLast()
        return Operational(leftNum, rightNum)
    }
}
