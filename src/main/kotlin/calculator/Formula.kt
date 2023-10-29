package calculator

class Formula(input: String) {

    val tokens: List<FormulaToken>
    val initValue: Int

    init {
        require(input.isNotBlank()) { "공백 문자를 사용할 수 없습니다." }
        require(input[0].isDigit()) { "첫글자는 숫자만 입력할 수 있습니다." }

        val chars = input.replace(WHITE_SPACE_REGEX, WHITE_SPACE_REPLACE_CHARACTER)
            .let { TOKEN_SEPARATE_REGEX.findAll(it) }
            .map { it.groupValues[0] }
            .toList()

        initValue = chars[0].toInt()
        tokens = chars.subList(1, chars.size).chunked(2)
            .map { FormulaToken(it.joinToString("")) }
            .toList()
    }

    companion object {
        private const val WHITE_SPACE_REPLACE_CHARACTER = ""
        private val WHITE_SPACE_REGEX = "\\s+".toRegex()
        private val TOKEN_SEPARATE_REGEX = "(\\p{Punct}+)|(\\d+)".toRegex()
    }
}
