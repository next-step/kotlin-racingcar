package step3_racingcar.validator

import step3_racingcar.util.extension.isPositive

class InputValidator {
    fun inputValidate(input: String?) {
        require(!input.isNullOrBlank()) { "입력 값은 공백 또는 빈 문자열일 수 없습니다." }
        val number: Int = requireNotNull(input.toIntOrNull()) { "입력 값은 정수 여야 합니다." }
        require(number.isPositive()) { "입력 값은 1 이상이어야 합니다." }
    }
}
