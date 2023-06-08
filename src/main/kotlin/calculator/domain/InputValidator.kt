package calculator.domain

/**
 * 입력 유효성 검증
 */
class InputValidator {

    fun validate(text: String?): Boolean {
        return validateNullOrBlank(text)
    }

    private fun validateNullOrBlank(text: String?): Boolean {
        if (text.isNullOrBlank()) throw IllegalArgumentException("입력값이 Blank이거나 null이 되면 안됩니다.")
        return true
    }
}
