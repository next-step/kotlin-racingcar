package step2

class Reader {
    fun readExpression(): String {
        val expression: String? = readlnOrNull()
        requireNotNull(expression)
        require(expression.isNotBlank())

        return expression
    }
}