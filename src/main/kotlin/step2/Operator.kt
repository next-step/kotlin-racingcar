package step2

import java.util.function.BinaryOperator

enum class Operator : BinaryOperator<Int> {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
        override fun getOperand() = "+"
    },
    MINUS {
        override fun apply(t: Int, u: Int): Int = t - u
        override fun getOperand() = "-"
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
        override fun getOperand() = "*"
    },
    DIV {
        override fun apply(t: Int, u: Int): Int = t / u
        override fun getOperand() = "/"
    };

    abstract fun getOperand(): String
}
