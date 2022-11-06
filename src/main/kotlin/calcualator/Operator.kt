package calcualator

import java.lang.IllegalArgumentException

enum class Operator(val value: String) {
    ADD("+"),
    MINUS("-"),
    TIMES("*"),
    DIV("/");

    fun operate(result: Number, number: Number): Number {
        return when (this) {
            ADD -> result.plus(number)
            MINUS -> result.minus(number)
            TIMES -> result.times(number)
            DIV -> result.div(number)
        }
    }

    companion object {
        fun of(s: String): Operator {
            return values().firstOrNull { it.value == s }
                ?: throw IllegalArgumentException("적절한 연산자를 찾을 수 없습니다.")
        }
    }
}
