package calculator

class Input(
    val expression: String?
) {
    init {
        requireNotNull(expression) { "문자열 계산기의 입력은 null 일 수 없어요." }
        requireNotBlank(expression)
        requireValidExpression(expression)
    }

    companion object {
        val INPUT_VALIDATE_REGEX = Regex("[0-9+-\\/*\\s]+")
    }

    private fun requireNotBlank(expression: String) {
        require(expression.isNotBlank()) { "문자열 계산기의 입력은 빈 공백 문열일 수 없어요." }
    }

    private fun requireValidExpression(expression: String) {
        require(INPUT_VALIDATE_REGEX.matches(expression)) {
            "문자열 계산기의 입력은 사칙 연산과 숫자를 제외한 연산자는 들어올 수 없어요."
        }
    }
}
