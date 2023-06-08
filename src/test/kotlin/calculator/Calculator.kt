package calculator

class Calculator {

    companion object {
        private const val SPLIT_SYMBOL = " "
        private val regex = Regex("\\d+")
    }

    fun calculate(inputString: String?): Int {
        val strings = splitValidateInput(inputString)
        var sum = parseValidateNumber(strings[0])

        (1..strings.lastIndex).forEach { i ->
            val findOperator = OperatorType.findOperator(strings[i]) ?: return@forEach
            sum = findOperator.calculate(sum, parseValidateNumber(strings[i + 1]))
        }

        return sum
    }

    private fun splitValidateInput(string: String?): List<String> {
        if (string.isNullOrBlank() || string.split(SPLIT_SYMBOL).size % 2 == 0) {
            throw IllegalArgumentException("사칙연산을 할 수 없는 문자열입니다.")
        }

        return string.split(SPLIT_SYMBOL)
    }

    private fun parseValidateNumber(number: String): Int {
        if (!regex.matches(number))
            throw IllegalArgumentException("피연산자 자리에는 숫자가 와야합니다.")

        return Integer.parseInt(number)
    }

    private fun plus(firstNumber: Int, secondNumber: Int): Int {
        return firstNumber.plus(secondNumber)
    }

    private fun minus(firstNumber: Int, secondNumber: Int): Int {
        return firstNumber.minus(secondNumber)
    }

    private fun multiply(firstNumber: Int, secondNumber: Int): Int {
        return firstNumber.times((secondNumber))
    }

    private fun divide(firstNumber: Int, secondNumber: Int): Int {
        return firstNumber.div((secondNumber))
    }
}
