package calculator.domain

import java.util.regex.Pattern

class Expression(
    private val left: Operand,
    private val right: Operand,
    private val operator: Operator
) {
    fun calculate() = operator.apply(left.value, right.value)

    companion object {
        private val REGEX = Pattern.compile("[\\d */+-]+")

        fun validate(expression: String?): String {
            require(!expression.isNullOrBlank()) { "입력값은 null 또는 빈문자열일 수 없습니다." }
            require(REGEX.matcher(expression).matches()) { "입력값에 올바르지 않은 문자열이 포함되어 있습니다." }

            return expression
        }
    }
}
