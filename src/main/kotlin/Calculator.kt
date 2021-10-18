class Calculator(private val inputLine: String?) {

    private val numbers = mutableListOf<Int>()
    private val operators = mutableListOf<String>()
    private var result: Int = 0

    fun execute(): Int {
        return calculate()
    }

    private fun calculate(): Int {
        checkValidInput()
        classifyInput()

        result = numbers[0]
        operators.forEachIndexed { index, operator ->
            result = calculate(result, operator, numbers[index + 1])
        }
        return result
    }

    private fun classifyInput() {
        inputLine?.split(DECIMAL)?.forEach {
            when {
                it.matches(NUMBER_REGEX) -> numbers.add(it.toInt())
                it.matches(OPERATOR_REGEX) -> operators.add(it)
                else -> throw IllegalArgumentException(ErrorMessage.NO_ARITHMETIC_OPERATION)
            }
        }
    }

    private fun checkValidInput() {
        if (inputLine.isNullOrBlank()) {
            throw IllegalArgumentException(ErrorMessage.INVALID_ERROR)
        }
    }

    private fun calculate(left: Int, operator: String, right: Int): Int {
        val currentOperator = Operator.getOperator(operator)
        return currentOperator.operate.invoke(left, right)
    }
}

private const val DECIMAL = " "
private val NUMBER_REGEX = "[0-9]+".toRegex()
private val OPERATOR_REGEX = "([+-/*])".toRegex()
