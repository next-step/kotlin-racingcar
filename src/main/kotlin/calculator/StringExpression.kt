package calculator

class StringExpression {
    companion object {
        private val formatRegex = """^[0-9]+(?: [+\-*/] [0-9]+)*$""".toRegex()

        fun validate(expression: String?): String {

            if (expression.isNullOrBlank()) throw IllegalArgumentException("expression is null or blank.")

            if (!formatRegex.matches(expression)) throw IllegalArgumentException("invalid expression format.")

            return expression
        }
    }
}
