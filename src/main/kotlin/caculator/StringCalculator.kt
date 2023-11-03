package caculator

class StringCalculator {
    fun calculate(input: String?): Int {
        require(input != null) { throw IllegalArgumentException("Input cannot be null") }

        val splitInput = input.split(" ")
        var result = splitInput[0].toInt()

        for (idx in 1 until splitInput.size step 2) {
            result = operate(result.toString(), splitInput[idx], splitInput[idx + 1])
        }

        return result
    }

    fun operate(left: String, operator: String, right: String): Int {
        val firstNumber = left.toInt()
        val secondNumber = right.toInt()
        return when (operator) {
            PLUS -> add(firstNumber, secondNumber)
            MINUS -> minus(firstNumber, secondNumber)
            MULTIPLY -> multiply(firstNumber, secondNumber)
            DIVIDE -> divide(firstNumber, secondNumber)
            else -> throw IllegalArgumentException("Invalid operator")
        }
    }

    private fun add(a: Int, b: Int) = a + b

    private fun minus(a: Int, b: Int) = a - b

    private fun multiply(a: Int, b: Int) = a * b

    private fun divide(a: Int, b: Int) = a / b

    companion object {
        const val PLUS = "+"
        const val MINUS = "-"
        const val MULTIPLY = "*"
        const val DIVIDE = "/"
    }
}
