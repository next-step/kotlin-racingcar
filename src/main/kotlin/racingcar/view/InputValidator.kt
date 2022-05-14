package racingcar.view

object InputValidator {
    private const val ERROR_MSG_FOR_NATURAL_NUMBER = "1이상 정수로 입력해주세요"
    private const val MAX_NAME_LENGTH = 5
    private const val ERROR_MSG_FOR_NAME_LENGTH = "자동차 이름은 ${MAX_NAME_LENGTH}자를 초과할 수 없어요"

    fun checkNaturalNumber(input: String) {
        require(input.toInt() > 0) { ERROR_MSG_FOR_NATURAL_NUMBER }
    }

    fun checkNameLength(names: List<String>) {
        require(names.all { it.length <= MAX_NAME_LENGTH }) { ERROR_MSG_FOR_NAME_LENGTH }
    }
}
