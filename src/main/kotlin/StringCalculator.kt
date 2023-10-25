class StringCalculator {
    companion object {
        private const val INPUT_VALID_ERROR_MESSAGE: String = "입력값이 null이거나 빈 공백 문자입니다."
        private const val BAD_INPUT_VALUE_MESSAGE: String = "입력값이 잘못되었습니다."
        private const val NOT_OPERATOR_MESSAGE: String = "사칙연산 기호가 아닙니다."
    }

    fun calculate(input: String): Int {
        if (input.isBlank()) {
            throw IllegalArgumentException(INPUT_VALID_ERROR_MESSAGE)
        }
        val splitInput = input.split(" ")
        var result = splitInput.first().toIntOrNull() ?: throw IllegalArgumentException(BAD_INPUT_VALUE_MESSAGE)

        for (index in 1 until splitInput.size step 2) {
            val operator = splitInput[index]
            val targetNumber = splitInput[index + 1].toIntOrNull() ?: throw IllegalArgumentException(BAD_INPUT_VALUE_MESSAGE)

            result = calculation(result, targetNumber, operator)
        }

        return result
    }

    private fun calculation(firstNumber: Int, secondNumber: Int, operate: String): Int {
        return when (operate) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "/" -> firstNumber / secondNumber
            "*" -> firstNumber * secondNumber
            else -> throw IllegalArgumentException(NOT_OPERATOR_MESSAGE)
        }
    }
}
