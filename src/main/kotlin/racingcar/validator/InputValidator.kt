package racingcar.validator

import racingcar.util.extension.isPositive

class InputValidator {
    fun inputValidate(input: String?): String {
        require(!input.isNullOrBlank()) { "입력 값은 공백 또는 빈 문자열일 수 없습니다." }
        return input
    }

    fun numberValidate(input: String): Int {
        val number: Int = requireNotNull(input.toIntOrNull()) { "입력 값은 정수 여야 합니다." }
        require(number.isPositive()) { "입력 값은 1 이상이어야 합니다." }
        return number
    }
}
