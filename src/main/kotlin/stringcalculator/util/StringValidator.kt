package stringcalculator.util

object StringValidator {
    fun validateNumber(string: String) {
        val isNumeric = string.toCharArray().all { it in '0'..'9' }
        if (!isNumeric) {
            throw IllegalArgumentException("숫자 자리에 다른 문자가 입력되었습니다.")
        }
    }

    fun validateNotBlank(string: String) {
        if (string.isBlank()) {
            throw IllegalArgumentException("입력값이 비어있습니다. 올바른 값을 입력해주세요.")
        }
    }
}
