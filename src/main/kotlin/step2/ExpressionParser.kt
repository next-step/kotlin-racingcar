package step2

class ExpressionParser(private val expression: List<String>) {
    companion object {
        fun of(input: String): ExpressionParser {
            val expression = input.trim().split(" ")
            require(expression.isNotEmpty()) { "공백 문자가 입력될 수 없습니다." }
            return ExpressionParser(expression)
        }
    }

    fun getOperands(): List<Int> {
        return expression
            .filterIndexed { index, _ -> index % 2 == 0 }
            .map { it.toInt() }
    }

    fun getOperators(): List<Operator> {
        return expression
            .filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.of(it) ?: throw IllegalArgumentException() }
    }
}
