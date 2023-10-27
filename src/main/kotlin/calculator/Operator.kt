package calculator

enum class Operator(
    private val operator: String,
    val operation: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    TIMES("*", { a, b -> a * b }),
    DIV("/", { a, b ->
        require(b != 0) { "0으로 나눌 수 없습니다." }
        a / b
    }),
    ;

    companion object {
        fun from(operator: String): Operator =
            values().find { it.operator == operator } ?: throw IllegalArgumentException("입력 값에 사칙 연산이 아닌 기호가 포함되었습니다.")
    }
}
