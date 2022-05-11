package operator.domain

import java.util.function.BiFunction

enum class OperatorToken(val token: String, private val biFunction: BiFunction<Operand, Operand, Operand>) {
    PLUS("+", { one, two -> one + two }),
    MINUS("-", { one, two -> one - two }),
    TIMES("*", { one, two -> one * two }),
    DIV("/", { one, two -> one / two });

    companion object {
        private val operatorToken: Map<String, OperatorToken> = mapOf(
            PLUS.token to PLUS,
            MINUS.token to MINUS,
            TIMES.token to TIMES,
            DIV.token to DIV,
        )

        fun getInstance(token: String): OperatorToken {
            return operatorToken[token] ?: throw IllegalArgumentException("잘못된 연산자 입니다.")
        }
    }

    fun calculate(one: Operand, two: Operand): Operand {
        return biFunction.apply(one, two)
    }
}
