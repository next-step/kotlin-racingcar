package calculator

enum class Operator(private val operator: String, val calculation: (a: Int, b: Int) -> Int) {
    ADD("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    TIMES("*", { a, b -> a * b }),
    DIVIDE(
        "/",
        { a, b ->
            if (b == 0) {
                throw java.lang.ArithmeticException("0으로 나눌 수 없습니다.")
            }
            a / b
        }
    );

    companion object {
        fun selectOperator(operator: String): Operator {
            return values().find { operator == it.operator }
                ?: throw IllegalArgumentException("사칙연산 부호가 아닙니다.")
        }
    }
}
