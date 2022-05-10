package calculator

enum class Operator(
    val value: String,
    val expression: (firstValue: Int, secondValue: Int) -> Int
) {
    PLUS("+", { firstValue: Int, secondValue: Int -> firstValue + secondValue }),
    MINUS("-", { firstValue: Int, secondValue: Int -> firstValue - secondValue }),
    MULTIPLICATION("*", { firstValue: Int, secondValue: Int -> firstValue * secondValue }),
    DIVISION("/", { firstValue: Int, secondValue: Int -> firstValue / secondValue });


    companion object {
        const val NOT_SUPPORT_OPERATOR = "지원하지 않는 연산자 입니다."

        fun of(value: String): Operator {
            return values().firstOrNull { it.value == value }
                ?: throw IllegalArgumentException(NOT_SUPPORT_OPERATOR)
        }
    }
}
