package stringcalculator.util

object StringValidator {
    fun validateNumber(targetNumber: String) {
        if (!targetNumber.matches(Regex("[0-9]+"))) {
            throw IllegalArgumentException("숫자 자리에 다른 문자가 입력되었습니다.")
        }
    }

    fun validateNotBlank(string: String?) {
        if (string == null) {
            throw IllegalArgumentException("입력값이 null 입니다. 올바른 값을 입력해주세요.")
        }
        if (string.isBlank()) {
            throw IllegalArgumentException("입력값이 비어있습니다. 올바른 값을 입력해주세요.")
        }
    }
}
