package calculator

object ExpressionChecker {
    fun isEmpty(number: List<Int>, expression: List<Operator>) = number.isNullOrEmpty() || expression.isNullOrEmpty()
    fun isValidExpressionSize(number: List<Int>, expression: List<Operator>) = number.size - 1 == expression.size
}
