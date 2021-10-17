class Calculator(private val inputLine: String?) {

    private val numbers = mutableListOf<Int>()
    private val operators = mutableListOf<String>()
    private var result: Int = 0

    fun excute(): Int {
        checkValidInput()
        return calculate()
    }

    private fun calculate(): Int {
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
                it.isNumber() -> numbers.add(it.toInt())
                it.matches(OPERATOR_REGEX) -> operators.add(it)
                else -> throw IllegalArgumentException("사칙 연산 기호가 아닙니다.")
            }
        }
    }

    private fun checkValidInput() {
        if (inputLine.isNullOrBlank()) {
            throw IllegalArgumentException("올바르지 않는 입력 값입니다.")
        }
    }

    private fun calculate(left: Int, operator: String, right: Int): Int {
        val currentOperator = Operator.getOperator(operator)
        return currentOperator.excute(left, right)
    }
}

fun String.isNumber(): Boolean {
    return this.isNotEmpty() && this.matches(Regex("\\d+"))
}

private const val DECIMAL = " "
private val NUMBER_REGEX = "[0-9]+".toRegex()
private val OPERATOR_REGEX = "([+-/*])".toRegex()
