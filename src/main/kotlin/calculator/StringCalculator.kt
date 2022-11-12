package calculator

object StringCalculator {

    fun calculate(input: String?): Long {

        require(!input.isNullOrBlank()) { "입력값은 null이나 빈 공백 문자일 수 없습니다." }

        val split: List<String> = input.split(" ")
        require(split.size % 2 != 0) { "피연산자, 연산자의 개수의 합은 홀수여야 합니다." }

        var result = split[0].toLongOrThrow()
        for (i in 1 until split.size step 2) {

            val operator = ArithmeticOperator.of(split[i])
            val operand = split[i + 1].toLongOrThrow()

            result = operator.operate(result, operand)
        }

        return result
    }

    private fun String.toLongOrThrow(): Long {
        return toLongOrNull()
            ?: throw IllegalArgumentException("피연산자는 반드시 숫자여야 합니다.")
    }
}
