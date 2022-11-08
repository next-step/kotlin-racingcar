package step2

import java.lang.IllegalArgumentException

enum class OperatorSign(
    val sign: String,
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    companion object {
        fun getBySign(sign: String): OperatorSign {
            return when (sign) {
                PLUS.sign -> PLUS
                MINUS.sign -> MINUS
                MULTIPLE.sign -> MULTIPLE
                DIVIDE.sign -> DIVIDE
                else -> throw IllegalArgumentException("연산 기호는 +, -, *, / 만 입력할 수 있습니다.")
            }
        }
    }
}
