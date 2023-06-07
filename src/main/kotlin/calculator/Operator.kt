package calculator

enum class Operator(
    val sign: String,
    val operate: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    TIMES("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> if (b == 0) throw IllegalArgumentException("숫자는 0으로 나눌 수 없다.") else a / b }),
    ;

    companion object {
        fun parseToOperator(sign: String): Operator =
            values().firstOrNull { it.sign == sign } ?: throw IllegalArgumentException("올바른 연산자를 입력하여야 한다.")
    }
}
