package step2.stringcalculator

import step2.stringcalculator.parser.ExpressionParser
import step2.stringcalculator.parser.Token
import step2.stringcalculator.parser.TokenInvalid
import step2.stringcalculator.parser.TokenNumber

class SimpleCalculator {

    fun evaluation(expression: String?): Double {

        val calculatorContext = CalculatorContext()
        val arguments = ExpressionParser.parse(expression)
        arguments.forEach { arg ->
            if (arg is TokenInvalid) {
                throw IllegalArgumentException("Invalid argument : $arg")
            }
            calculatorContext.putToken(token = arg)
        }
        return calculatorContext.complete()
    }

    private class CalculatorContext {
        private var result: Double? = null
        private var lastToken: Token? = null

        fun putToken(token: Token) {
            val lastToken = this.lastToken
            checkTokenTypeSequence(lastToken, token)

            if (token is TokenNumber) {
                this.result = lastToken?.calculate(result, token.doubleValue) ?: token.doubleValue
            }

            this.lastToken = token
        }

        fun complete(): Double {
            val lastToken = this.lastToken
            if (lastToken?.isOperator == true) {
                throw IllegalArgumentException("Needless operator at the end of input : ${lastToken.value}")
            }
            return this.result ?: 0.0
        }

        private fun checkTokenTypeSequence(lastToken: Token?, currentToken: Token) {
            if (lastToken?.type == currentToken.type) {
                val typeString = if (lastToken.isOperator) "operator" else "number"
                throw IllegalArgumentException("continuous $typeString input found  : ${lastToken.value} , ${currentToken.value}")
            }

            if (lastToken == null && currentToken.isOperator) {
                throw IllegalArgumentException("Expression starts with operator : ${currentToken.value} ")
            }
        }
    }
}
