package step2

private const val INPUT_NULL_OR_BLANK_ERROR_MESSAGE = "입력 값은 null 이거나 공백일 수 없습니다."

private const val DELIMITER = " "

class StringCalculator {

    fun calculate(input: String?): Int {
        val elements = parse(input)
        var result = elements[0].toInt()
        for (i in 1 until elements.size step (2)) {
            val num = elements[i + 1].toInt()
            val operator = MathOperator.from(elements[i])
            result = operator.calculate(result, num)
        }
        return result
    }

    private fun parse(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(INPUT_NULL_OR_BLANK_ERROR_MESSAGE)
        }

        return input.split(DELIMITER)
    }
}
