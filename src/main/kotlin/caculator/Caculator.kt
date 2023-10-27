package caculator

import java.util.LinkedList
import java.util.Queue

object Caculator {

    /**
     * Calculates if the [input] is a correct mathematical expression.
     *
     * @param input String of mathematical expression.
     * @throws IllegalArgumentException If the [input] is not a correct mathematical expression.
     */
    fun calculate(input: String?): Double {
        val expression = input.toExpression()

        var result = 0.0
        var curSymbol: Token.Symbol? = null
        while (expression.peek() != null) {
            when (val curToken = expression.poll()) {
                is Token.Number -> {
                    result = calculateDouble(result, curSymbol, curToken.value)
                    curSymbol = null
                }
                is Token.Symbol -> {
                    curSymbol = curToken
                }
            }
        }

        return result
    }

    @Throws(IllegalArgumentException::class)
    private fun String?.toExpression(): Queue<Token> {
        require(!this.isNullOrBlank())

        return this.split(" ").filter {
            it.isNotEmpty()
        }.mapIndexed { i, s ->
            s.toTokenOrNull()?.let {
                require(i % 2 == 0 && it is Token.Number || i % 2 == 1 && it is Token.Symbol)
                it
            } ?: throw IllegalArgumentException("잘못된 계산식입니다.")
        }.let {
            LinkedList(it)
        }
    }

    private fun String.toTokenOrNull(): Token? {
        return this.toDoubleOrNull()?.let {
            Token.Number(it)
        } ?: when (this) {
            Token.Symbol.PLUS.strValue -> Token.Symbol.PLUS
            Token.Symbol.MINUS.strValue -> Token.Symbol.MINUS
            Token.Symbol.TIMES.strValue -> Token.Symbol.TIMES
            Token.Symbol.DIVISION.strValue -> Token.Symbol.DIVISION
            else -> null
        }
    }

    private fun calculateDouble(num1: Double, symbol: Token.Symbol?, num2: Double): Double {
        return when (symbol) {
            Token.Symbol.PLUS -> num1 + num2
            Token.Symbol.MINUS -> num1 - num2
            Token.Symbol.TIMES -> num1 * num2
            Token.Symbol.DIVISION -> num1 / num2
            null -> num2
        }.also {
            require(it.isFinite())
        }
    }

    private sealed interface Token {
        class Number(val value: Double) : Token
        enum class Symbol(val strValue: String) : Token {
            PLUS("+"), MINUS("-"), TIMES("*"), DIVISION("/")
        }
    }
}
