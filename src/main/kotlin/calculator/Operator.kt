package calculator

enum class Operator(
    private val sign: String,
    private val calculation: (Number, Number) -> Number
) {
    ADDITION("+", { a, b -> Number(a.value + b.value) }),
    SUBTRACTION("-", { a, b -> Number(a.value - b.value) }),
    MULTIPLICATION("*", { a, b -> Number(a.value * b.value) }),
    DIVISION("/", { a, b -> Number(a.value / b.value) }),
    ;

    fun calculate(a: Number, b: Number): Number = calculation(a, b)

    companion object {
        fun findBySign(sign: String): Operator {
            return values().firstOrNull { it.sign == sign }
                ?: throw IllegalArgumentException("$sign 에 해당하는 연산자를 찾지 못했습니다.")
        }
    }
}
