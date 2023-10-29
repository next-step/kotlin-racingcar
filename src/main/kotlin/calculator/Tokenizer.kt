package calculator

object Tokenizer {
    private const val validInputRegex = "[\\d+\\-*/\\s]*"

    fun validate(input: String?) {
        require(!input.isNullOrBlank(), { "입력값은 null이거나 빈 공백 문자일 수 없다." })
        require(input.matches(Regex(validInputRegex)), { "입력값은 숫자, 사칙연산자, 공백만 들어올 수 있다." })
    }

    fun tokenize(input: String, pattern: String = "\\s+"): List<String> {
        this.validate(input)
        return input
            .split(Regex(pattern))
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    }
}