private const val SPLIT_SYMBOL = " "
private val regex = Regex("\\d+")

class Calculator {
    private fun validateInput(string: String?) {
        if (string.isNullOrBlank() || string.split(SPLIT_SYMBOL).size % 2 == 0)
            throw IllegalArgumentException("사칙연산을 할 수 없는 문자열입니다.")
    }

    private fun validateNumber(firstNumber: String, secondNumber: String) {
        if (!regex.matches(firstNumber) || !regex.matches(secondNumber))
            throw IllegalArgumentException("피연산자 자리에는 숫자가 와야합니다.")
    }

    private fun plus(firstNumber: String, secondNumber: String): Int {
        validateNumber(firstNumber, secondNumber)
        return Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber)
    }

    fun calculate(inputString: String?): Int {
        // validateInput(inputString)

        if (inputString.isNullOrBlank() || inputString.split(SPLIT_SYMBOL).size % 2 == 0)
            throw IllegalArgumentException("사칙연산을 할 수 없는 문자열입니다.")

        val strings = inputString.split(SPLIT_SYMBOL)

        var sum = 0

        strings.withIndex().forEach { (index, string) ->
            when (string) {
                "+" -> sum += plus(strings[index - 1], strings[index + 1])
            }
        }

        return sum
    }
}
