package calculator

class StringCalculator {

    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException("input 값 비어 있어!!!") }

        val split = input.split(" ")
        val remainingElements = split.drop(1)
        var result = split.first().toInt()

        for (i in 0 until remainingElements.size / 2) {
            val operation = remainingElements[i * 2]
            val operand = remainingElements[i * 2 + 1].toInt()
            result = applyOperation(result, operation, operand)
        }
        return result
    }

    private fun applyOperation(currentValue: Int, operation: String, operand: Int): Int {
        try {
            val operator = Operation.values().first { it.operation == operation }
            return operator.operate(currentValue, operand)
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException()
        }
    }
}
