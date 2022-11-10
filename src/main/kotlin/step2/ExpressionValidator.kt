package step2

object ExpressionValidator {

    fun validate(expression: String?): String {
        require(!expression.isNullOrBlank()) { "입력한 계산식은 null 또는 공백이 될 수 없습니다." }
        return expression
    }
}
