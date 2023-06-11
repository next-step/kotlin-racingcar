package calculator

object Validator {

    fun validate(str: String?): String {
        requireNotNull(str) { "입력값이 null입니다." }

        val regexPattern = """^[0-9\s\+\-\/\*]+$""".toRegex()
        require(regexPattern.matches(str)) { "입력값에 올바르지 않은 문자가 포함되어 있습니다." }
        return str
    }
}
