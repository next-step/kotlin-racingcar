package step2.stringcalculator.parser

abstract class Token(val value: String, val type: TokenType) {

    enum class TokenType {
        NUMBER, OPERATOR, INVALID
    }

    val isOperator = this.type == TokenType.OPERATOR
    open fun calculate(operand1: Double, operand2: Double) = 0.0
}

class TokenOperatorPlus : Token("+", TokenType.OPERATOR) {
    override fun calculate(operand1: Double, operand2: Double) = operand1 + operand2
}

class TokenOperatorMinus : Token("-", TokenType.OPERATOR) {
    override fun calculate(operand1: Double, operand2: Double) = operand1 - operand2
}

class TokenOperatorMultiply : Token("*", TokenType.OPERATOR) {
    override fun calculate(operand1: Double, operand2: Double) = operand1 * operand2
}

class TokenOperatorDivide : Token("/", TokenType.OPERATOR) {

    override fun calculate(operand1: Double, operand2: Double): Double {
        if (operand2 == 0.0) {
            throw throw IllegalArgumentException("Can't divide by 0")
        }
        return operand1 / operand2
    }
}

class TokenInvalid(value: String) : Token(value, TokenType.INVALID)
class TokenNumber(value: String) : Token(value, TokenType.NUMBER) {
    val doubleValue = value.toDouble()
    override fun calculate(operand1: Double, operand2: Double) = doubleValue
}
