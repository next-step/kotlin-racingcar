package racingcar

object InputValidator {
    private const val ERROR_MSG_FOR_NATURAL_NUMBER = "1이상 정수로 입력해주세요"
    fun checkNaturalNumber(input: String) {
        require(input.toInt() > 0) { ERROR_MSG_FOR_NATURAL_NUMBER }
    }
}
