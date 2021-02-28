package calculator

import java.util.Stack

enum class Operator : Word {
    PLUS {
        override val operation: (n1: Number, n2: Number) -> Number
            get() = { n1, n2 -> n1 + n2 }
    },
    MINUS {
        override val operation: (n1: Number, n2: Number) -> Number
            get() = { n1, n2 -> n1 - n2 }
    },
    TIMES {
        override val operation: (n1: Number, n2: Number) -> Number
            get() = { n1, n2 -> n1 * n2 }
    },
    DIVIDE {
        override val operation: (n1: Number, n2: Number) -> Number
            get() = { n1, n2 -> n1 / n2 }
    },
    ;

    abstract val operation: (n1: Number, n2: Number) -> Number

    override fun calc(resultStack: Stack<Number>) {
        val n1 = resultStack.pop()
        val n2 = resultStack.pop()
        val result = operation(n2, n1)
        resultStack.add(result)
    }

    companion object {
        fun of(value: String): Operator {
            return when (value.trim()) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> TIMES
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("the value not Operator")
            }
        }
    }
}
