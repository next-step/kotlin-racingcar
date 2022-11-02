package calculator.domain

class Calculator(private val parser: BlankParser = BlankParser()) {

    fun calculate(expression: String): Int {
        val operands = parser.parseOperands(expression)
        val operators = parser.parseOperators(expression)

        val something = OperandsAndOperators(operands, operators)
        something.operate();
        return something.getResult();
    }
}
