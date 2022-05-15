package calculator

enum class Operator(val symbol: String, val operate: (Float, Float) -> Float) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDED("/", { a, b -> a / b });

    companion object {
        fun of(symbol: String): Operator = values().firstOrNull { it -> it.symbol == symbol }
            ?: throw IllegalArgumentException("$symbol 은(는) 옵바른 사칙연산 기호가 아닙니다. (사용 가능 연산: + - * / )")
    }
}
