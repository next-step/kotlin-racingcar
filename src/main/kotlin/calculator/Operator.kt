package calculator

import java.util.Stack

enum class Operator(val token: String, val operate: (n1: Number, n2: Number) -> Number) : Word {
    PLUS("+", { n1, n2 -> n1 + n2 }),
    MINUS("-", { n1, n2 -> n1 - n2 }),
    TIMES("*", { n1, n2 -> n1 * n2 }),
    DIVIDE("/", { n1, n2 -> n1 / n2 }),
    ;

    override fun calculate(acc: Stack<Number>) {
        val n1 = acc.pop()
        val n2 = acc.pop()
        val result = operate(n2, n1)
        acc.add(result)
    }

    companion object {
        fun of(value: String): Operator {
            return when (value.trim()) {
                PLUS.token -> PLUS
                MINUS.token -> MINUS
                TIMES.token -> TIMES
                DIVIDE.token -> DIVIDE
                else -> throw IllegalArgumentException("the value not Operator")
            }
        }
    }
}
