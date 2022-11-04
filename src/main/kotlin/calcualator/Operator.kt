package calcualator

import java.lang.IllegalArgumentException

enum class Operator(val value: String) {
    ADD("+"),
    MINUS("-"),
    TIMES("*"),
    DIV("/");

    companion object {
        fun of(s: String): Operator {
            return values().firstOrNull { it.value == s } ?:
            throw IllegalArgumentException("적절한 연산자를 찾을 수 없습니다.")
        }
    }
}
