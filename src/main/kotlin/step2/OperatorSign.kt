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
            return OperatorSign.values().find { it.sign == sign }
                ?: throw throw IllegalArgumentException("연산 기호는 +, -, *, / 만 입력할 수 있습니다.")
        }
    }
}
