package step3.util

object InputValidator {
    private const val EMPTY_USER_INPUT_MESSAGE = "반드시 값이 입력되어야 합니다."
    private const val INVALID_USER_INPUT_MESSAGE = "반드시 0 이상의 값이 입력되어야 합니다."

    fun validate(input: String?): Int {
        requireNotNull(input) {
            EMPTY_USER_INPUT_MESSAGE
        }

        return input.toInt().also { inputNumber ->
            require(inputNumber >= 0) {
                INVALID_USER_INPUT_MESSAGE
            }
        }
    }
}