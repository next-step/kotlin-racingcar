package step2

/**
 * 사칙연산자 체크 및 제한을 위한 Operator Enum class
 * Created by Jaesungchi on 2022.05.05..
 */
enum class Operator(
    val char: String
) {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVISION("/");

    companion object {
        fun of(char: String): Operator = values().find { it.char == char }
            ?: throw IllegalArgumentException(ErrorMessage.IS_NON_OPERATOR_CHARACTER)
    }
}
