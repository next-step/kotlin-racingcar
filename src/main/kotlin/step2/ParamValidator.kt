package step2

object ParamValidator {
    fun validateNotNull(s: String?) {
        if (s == null) {
            throw IllegalArgumentException("입력값이 null 입니다.")
        }
    }

    fun validateNonEmpty(s: String?) {
        if (s!!.trim().isEmpty()) {
            throw IllegalArgumentException("입력값이 비어 있거나 공백 문자입니다.")
        }
    }
}