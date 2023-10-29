package calculator

class ExpressionParser {
    fun parse(expression: String): Expression {
        val (left, operator, right) = expression.split(" ")

        try {
            return Expression(left.toLong(), right.toLong(), Operator.valueOf(operator))
        } catch (formatException: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력 가능합니다.")
        } catch (notFoundException: NoSuchElementException) {
            throw IllegalArgumentException("사칙연산 기호만 입력 가능합니다.")
        }
    }
}
