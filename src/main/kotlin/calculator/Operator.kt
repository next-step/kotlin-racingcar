package calculator

enum class Operator(val operator: String) {
    PLUS("+"), MINUS("-"), DIVISION("/"), MULTIPLE("*");

    companion object {
        private val map = Operator.values().associateBy { it.operator }
        fun find(operator: String) = map[operator]!!
    }
}

fun isOperatorValid(expression: String) = extractOperator(expression).isNotBlank()

fun extractOperator(expression: String) = extractNumber(expression).replace(Regex("[+|\\-|/|*]"), "")
