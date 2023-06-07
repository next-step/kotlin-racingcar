package study.step2.calculate

enum class OperationSymbol(
    val value: String,
    val operation: (Int, Int) -> Int,
) {
    PLUS("+", { result, number -> result + number }),
    MINUS("-", { result, number -> result - number }),
    MULTIPLY("*", { result, number -> result * number }),
    DIVIDE("/", { result, number ->
        if (number != 0) result / number else throw ArithmeticException("0으로 나눌 수 없습니다.")
    }),
    ;

    companion object {
        fun findBySymbol(value: String): OperationSymbol {
            return values().find { it.value == value }
                ?: throw IllegalArgumentException("${value}는 사칙연산 기호가 아닙니다.")
        }

        fun initPlusSymbol(): String {
            return PLUS.value
        }
    }

    fun operate(result: Int, number: Int): Int = operation(result, number)
}
