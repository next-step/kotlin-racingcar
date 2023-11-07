package calculator

fun checkNullOrBlank(expression: String?): String =
    if (expression.isNullOrBlank()) {
        throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다")
    } else {
        expression
    }
