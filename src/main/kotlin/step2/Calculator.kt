package step2

class Calculator(private val inputLine: String?) {

    private val numbers = mutableListOf<Int>()
    private val operators = mutableListOf<String>()
    private var result: Int = 0

    fun calculate(): Int {
        checkValidInput()
        classifyInput()
        return getResult()
    }

    private fun getResult(): Int {
        result = numbers[0]
        operators.forEachIndexed { index, operator ->
            result = calculate(result, operator, numbers[index + 1])
        }
        return result
    }

    private fun classifyInput() {
        inputLine?.split(BLANK)?.forEach {
            val isNumber = it.toIntOrNull() != null
            when {
                isNumber -> numbers.add(it.toInt())
                Operator.hasOperator(it) -> operators.add(it)
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

private const val BLANK = " "
