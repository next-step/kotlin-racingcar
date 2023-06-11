package calculator

class ExpressionParser(private val expression: List<String>) {

    fun getOperands(): List<Int> {
        return expression
            .filterIndexed { index, _ -> !isOdd(index) }
            .map { it.toInt() }
    }

    fun getOperators(): List<Operator> {
        return expression
            .filterIndexed { index, _ -> isOdd(index) }
            .map { Operator.of(it) ?: throw IllegalArgumentException() }
    }

    private fun isOdd(index: Int): Boolean {
        return index % 2 == 1
    }

    companion object {
        fun of(input: String): ExpressionParser {
            val expression = input.trim().split(" ")
            require(expression.isNotEmpty()) { "공백 문자가 입력될 수 없습니다." }
            return ExpressionParser(expression)
        }
    }
}
