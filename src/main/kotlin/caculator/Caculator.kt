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
        var curSymbol: Symbol? = null
        while (expression.peek() != null) {
            when (val curToken = expression.poll()) {
                is Number -> {
                    result = curSymbol?.operate(result, curToken.value) ?: curToken.value
                    curSymbol = null
                }
                is Symbol -> {
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
                require(i % 2 == 0 && it is Number || i % 2 == 1 && it is Symbol)
                it
            } ?: throw IllegalArgumentException("잘못된 계산식입니다.")
        }.let {
            LinkedList(it)
        }
    }

    private fun String.toTokenOrNull(): Token? {
        return this.toDoubleOrNull()?.let {
            Number(it)
        } ?: when (this) {
            Symbol.PLUS.strValue -> Symbol.PLUS
            Symbol.MINUS.strValue -> Symbol.MINUS
            Symbol.TIMES.strValue -> Symbol.TIMES
            Symbol.DIVISION.strValue -> Symbol.DIVISION
            else -> null
        }
    }

    private sealed interface Token

    class Number(val value: Double) : Token

    enum class Symbol(val strValue: String) : Token {
        PLUS("+") {
            override fun operate(num1: Double, num2: Double): Double = (num1 + num2).also { require(it.isFinite()) }
        },
        MINUS("-") {
            override fun operate(num1: Double, num2: Double): Double = num1 - num2.also { require(it.isFinite()) }
        },
        TIMES("*") {
            override fun operate(num1: Double, num2: Double): Double = num1 * num2.also { require(it.isFinite()) }
        },
        DIVISION("/") {
            override fun operate(num1: Double, num2: Double): Double = num1 / num2.also { require(it.isFinite()) }
        };

        abstract fun operate(num1: Double, num2: Double): Double
    }
}
