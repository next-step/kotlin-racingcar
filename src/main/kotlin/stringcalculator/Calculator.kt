package stringcalculator

class Calculator(private val inputValidator: InputValidator, private val inputConverter: InputConverter) {
    fun calculate(input: String?): Int {
        val validatedInput = validateInput(input)
        val inputDeque = extractNumbers(validatedInput)
        val operations = convertToOperators(validatedInput)
        return executeOperations(inputDeque, operations)
    }

    private fun validateInput(input: String?): List<String> {
        return inputValidator.validate(input)
    }

    private fun extractNumbers(splitString: List<String>): ArrayDeque<Int> {
        return inputConverter.extractInts(splitString)
    }

    private fun convertToOperators(splitString: List<String>): List<Operator> {
        return inputConverter.convertToOperators(splitString)
    }

    private fun executeOperations(inputDeque: ArrayDeque<Int>, operators: List<Operator>): Int {
        for (operator in operators) {
            val operational = popFirstTwo(inputDeque)
            val result = operator.execute(operational)
            inputDeque.addFirst(result)
        }

        return inputDeque.first()
    }

    @Throws(NoSuchElementException::class)
    private fun popFirstTwo(inputDeque: ArrayDeque<Int>): Operational {
        val leftNum = inputDeque.removeFirst()
        val rightNum = inputDeque.removeFirst()
        return Operational(leftNum, rightNum)
    }
}
