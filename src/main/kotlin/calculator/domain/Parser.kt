package calculator.domain

interface Parser {
    fun parseOperators(expression: String): Operators
    fun parseOperands(expression: String): Operands
}
