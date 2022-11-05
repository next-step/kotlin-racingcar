package calculator

object Parser {
    private val DELIMITER_SPLIT_REGEX = "\\s+".toRegex()

    fun parse(rawString: String?): Expression {
        require(!rawString.isNullOrBlank()) { "입력 값은 널이나 빈 값이 들어올 수 없어요." }
        return Expression(rawString.split(DELIMITER_SPLIT_REGEX))
    }
}
