package step3

class InputView {
    fun getCarCount(): Int {
        println(INPUT_HOW_MANY_CAR)
        return getValidNaturalNumber(readln())
    }

    fun getTryCount(): Int {
        println(INPUT_HOW_MANY_TIMES)
        return getValidNaturalNumber(readln())
    }

    private fun getValidNaturalNumber(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INPUT_INVALID_NUMBER)
    }

    companion object {
        private const val INPUT_HOW_MANY_CAR = "자동차 대수는 몇 대인가요?"
        private const val INPUT_HOW_MANY_TIMES = "시도할 횟수는 몇 회인가요?"

        private const val ERROR_INPUT_INVALID_NUMBER = "유효한 숫자를 입력해 주세요"
    }
}
