package step2

class Reader {
    fun readExpression(): String {
        val expression: String? = readlnOrNull()
        return checkNotBlank(expression)
    }
}