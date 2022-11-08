package step2

import java.lang.IllegalArgumentException

enum class OperatorSign(
    val sign: String,
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("x"),
    DIVIDE("/");

    companion object {
        fun getBySign(sign: String): OperatorSign {
            return when (sign) {
                PLUS.sign -> PLUS
                MINUS.sign -> MINUS
                MULTIPLE.sign -> MULTIPLE
                DIVIDE.sign -> DIVIDE
                else -> throw IllegalArgumentException("잘못된 연산 기호를 입력했습니다.")
            }
        }
    }
}
