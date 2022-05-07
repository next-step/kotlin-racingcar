package study

object CalcSyntaxChecker {

    const val EMPTY_EXPRESSION_EXCEPTION = "비어있는 식은 사용할 수 없습니다."

    fun validate(expression: String) {
        if (expression.isBlank() || expression.isEmpty()) {
            throw IllegalArgumentException(EMPTY_EXPRESSION_EXCEPTION)
        }
    }
}
