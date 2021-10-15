package calculator.validator

import calculator.common.SPACE

object SimpleExpressionValidator : ExpressionValidator {
    override val regex: Regex
        get() = Regex("[\\d */+-]+")

    override fun validated(input: String?): String {
        require(!input.isNullOrBlank()) { "입력값은 비거나 NULL 값일 수 없습니다." }
        require(regex.matches(input)) { "입력값에 올바르지 않은 값이 포함되어 있습니다." }
        isSizeValid(input)
        return input
    }

    private fun isSizeValid(input: String) {
        val split = input.split(SPACE)
        require(split.size % 2 == 1) { "입력값의 길이가 올바르지 않습니다." }
    }
}
