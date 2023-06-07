private const val SPLIT_SYMBOL = " "
private val regex = Regex("\\d+")

class Calculator {
    private fun validateInput(string: String?) {
        if (string.isNullOrBlank() || string.split(SPLIT_SYMBOL).size % 2 == 0)
            throw IllegalArgumentException("사칙연산을 할 수 없는 문자열입니다.")
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

    fun calculate(inputString: String?): Int {
        // validateInput(inputString)

        if (inputString.isNullOrBlank() || inputString.split(SPLIT_SYMBOL).size % 2 == 0)
            throw IllegalArgumentException("사칙연산을 할 수 없는 문자열입니다.")

        val strings = inputString.split(SPLIT_SYMBOL)

        var sum = parseValidateNumber(strings[0])

        (1..strings.lastIndex).forEach { i ->
            when (strings[i]) {
                "+" -> sum = plus(sum, parseValidateNumber(strings[i + 1]))
                "-" -> sum = minus(sum, parseValidateNumber(strings[i + 1]))
                "*" -> sum = multiply(sum, parseValidateNumber(strings[i + 1]))
            }
        }

        return sum
    }
}
