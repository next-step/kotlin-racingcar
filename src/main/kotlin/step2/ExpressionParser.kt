package step2

interface ExpressionParser {
    fun parse(expression: String)

    fun getOperandsInOrder(): List<Int>

    fun getOperatorInOrder(): List<Operator>
}
