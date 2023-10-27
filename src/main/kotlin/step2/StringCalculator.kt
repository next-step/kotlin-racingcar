package step2

private const val INPUT_NULL_ERROR_MESSAGE = "입력 값은 null일 수 없습니다."

private const val INPUT_BLANK_ERROR_MESSAGE = "입력 값은 공백일 수 없습니다."

private const val DELIMITER = " "

class StringCalculator {

    fun calculate(input: String?): Int {
        val parseList = parse(input)
        var result = parseList[0].toInt()
        for (i in 1 until parseList.size step (2)) {
            val num = parseList[i + 1].toInt()
            val operator = MathOperator.from(parseList[i])
            result = operator.calculate(result, num)
        }
        return result
    }

    private fun parse(input: String?): List<String> {
        if (input == null) {
            throw IllegalArgumentException(INPUT_NULL_ERROR_MESSAGE)
        }

        if (input.isBlank()) {
            throw IllegalArgumentException(INPUT_BLANK_ERROR_MESSAGE)
        }

        return input.split(DELIMITER)
    }
}
