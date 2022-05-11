package calculator

enum class Operator(
    private val sign: String,
    private val calculation: (Int, Int) -> Int
) {
    ADDITION("+", { a, b -> a + b }),
    SUBTRACTION("-", { a, b -> a - b }),
    MULTIPLICATION("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> a / b }),
    ;

    fun calculate(a: Int, b: Int): Int = calculation(a, b)

    companion object {
        fun findBySign(sign: String): Operator {
            return values().firstOrNull { it.sign == sign }
                ?: throw IllegalArgumentException("$sign 에 해당하는 연산자를 찾지 못했습니다.")
        }
    }
}
