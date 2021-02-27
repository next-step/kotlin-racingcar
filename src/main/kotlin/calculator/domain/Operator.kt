package calculator.domain

enum class Operator(val code: String, val operate: (Number, Number) -> Number) {
    PLUS("+", { x, y -> x.plus(y) }),
    MINUS("-", { x, y -> x.minus(y) }),
    MULTIPLE("*", { x, y -> x.multiple(y) }),
    DIVIDE("/", { x, y -> x.divide(y) });

    companion object {
        @JvmStatic
        fun of(codetype: String): Operator {
            return values().firstOrNull { it.code == codetype } ?: throw IllegalArgumentException("허용하지 않는 연산자")
        }
    }
}
