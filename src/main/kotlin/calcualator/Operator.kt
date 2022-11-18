package calcualator

enum class Operator(
    val value: String,
    val expression: (Number, Number) -> Number
) {
    ADD("+", { a, b -> a.plus(b) }),
    MINUS("-", { a, b -> a.minus(b) }),
    TIMES("*", { a, b -> a.times(b) }),
    DIV("/", { a, b -> a.div(b) });

    companion object {
        fun of(s: String): Operator {
            return values().firstOrNull { it.value == s }
                ?: throw IllegalArgumentException("적절한 연산자를 찾을 수 없습니다.")
        }
    }
}
