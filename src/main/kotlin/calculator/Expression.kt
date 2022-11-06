package calculator

data class Expression(
    private val input: String?
) {
    private val expression: String

    init {
        require(!input.isNullOrBlank()) { "잘못된 입력입니다. 계산식을 입력해주세요" }
        require(Regex(OPERATION_REX).containsMatchIn(input)) { "잘못된 입력입니다. 숫자, 사칙연산 만 입력해주세요" }
        expression = input
    }
    
    companion object {
        private const val DELIMITER_WHITE_SPACE = " "
        private const val OPERATION_REX = "^[+\\-*/\\d]*$"
    }
}
