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
                    result = when (curSymbol) {
                        Token.Symbol.PLUS -> result + curToken.value
                        Token.Symbol.MINUS -> result - curToken.value
                        Token.Symbol.TIMES -> result * curToken.value
                        Token.Symbol.DIVISION -> result / curToken.value
                        null -> curToken.value
                    }
                    if (!result.isFinite()) throw IllegalArgumentException()
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
        if (this.isNullOrEmpty()) throw IllegalArgumentException()

        return this.split(" ").filter {
            it.isNotEmpty()
        }.mapIndexed { i, s ->
            s.toTokenOrNull()?.let {
                if ((i % 2 == 0 && it is Token.Number || i % 2 == 1 && it is Token.Symbol).not()) throw IllegalArgumentException()
                it
            } ?: throw IllegalArgumentException()
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

    private sealed interface Token {
        class Number(val value: Double) : Token
        enum class Symbol(val strValue: String) : Token {
            PLUS("+"), MINUS("-"), TIMES("*"), DIVISION("/")
        }
    }
}
