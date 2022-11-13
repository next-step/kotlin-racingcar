package calculator

object StringCalculator {

    private const val DELIMITER = " "

    fun calculate(input: String): Long {
        val splitInput: List<String> = splitInput(input)

        var result = splitInput[0].toLongOrThrow()
        for (i in 1 until splitInput.size step 2) {
            val arithmeticOperator = ArithmeticOperator.of(splitInput[i])
            val operand = splitInput[i + 1].toLongOrThrow()
            result = arithmeticOperator.operate(result, operand)
        }

        return result
    }

    private fun splitInput(input: String): List<String> {
        require(input.isNotBlank()) { "입력값은 빈 공백 문자일 수 없습니다." }

        val splitInput: List<String> = input.split(DELIMITER)
        require(splitInput.size % 2 != 0) { "피연산자, 연산자의 개수의 합은 홀수여야 합니다." }

        return splitInput
    }

    private fun String.toLongOrThrow(): Long {
        return toLongOrNull()
            ?: throw IllegalArgumentException("피연산자는 반드시 숫자여야 합니다.")
    }
}
