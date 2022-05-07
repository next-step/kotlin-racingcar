package step2

/**
 * 사칙연산자 체크 및 제한을 위한 Operator Enum class
 * Created by Jaesungchi on 2022.05.05..
 */
enum class Operator(
    val operator: String,
    val calculate: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> if (b == 0) throw IllegalArgumentException(ErrorMessage.CAN_NOT_DIVIDED_BY_ZERO) else a / b });

    companion object {
        fun of(operator: String): Operator = values().find { it.operator == operator }
            ?: throw IllegalArgumentException(ErrorMessage.IS_NON_OPERATOR_CHARACTER)
    }
}
