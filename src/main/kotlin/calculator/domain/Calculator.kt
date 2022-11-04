package calculator.domain

class Calculator(private val parser: Parser = BlankParser()) {

    fun calculate(expression: String): Int {
        val operands = parser.parseOperands(expression)
        val operators = parser.parseOperators(expression)

        return OperandsAndOperators(operands, operators).operate()
    }
}
