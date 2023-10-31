package calculator.application.port.`in`

import calculator.utill.ValidationRegex

@JvmInline
value class CalculateCommand(val expr: String?) {

    init {
        isValidInput(expr)
    }

    private fun isValidInput(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력 값이 없습니다.")
        }
        if (!input.matches(ValidationRegex.EXPRESSION_REGEX)) {
            throw IllegalArgumentException("올바르지 않는 형식입니다.")
        }
    }
}
