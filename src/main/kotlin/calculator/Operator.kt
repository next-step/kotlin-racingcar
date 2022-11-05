package calculator

import kotlin.IllegalArgumentException

enum class Operator(val op: String) : (Double, Double) -> Double {
    ADD("+") {
        override fun invoke(a: Double, b: Double): Double = a.plus(b)
    },
    MINUS("-") {
        override fun invoke(a: Double, b: Double): Double = a.minus(b)
    },
    DIVIDE("/") {
        override fun invoke(a: Double, b: Double): Double {
            require(b != 0.0) { "나누기를 진행할 때, 피연산자는 0이 될 수 없어요." }
            return a.div(b)
        }
    },
    MULTIPLY("*") {
        override fun invoke(a: Double, b: Double): Double = a.times(b)
    };

    companion object {
        fun from(op: String) = Operator.values().find { it.op == op } ?: throw IllegalArgumentException("올바른 연산자를 입력해주세요.")
        fun exist(op: String) = Operator.values().any { it.op == op }
    }
}
