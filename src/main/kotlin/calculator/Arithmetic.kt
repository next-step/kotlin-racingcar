package calculator

enum class Arithmetic(val symbols: String, val operation: (Number, Number) -> Number) {
    PLUS("+", Number::sum),
    MINUS("-", Number::subtract),
    MULTIPLY("*", Number::times),
    DIVIDE("/", Number::div);

    companion object {
        fun of(symbols: String): Arithmetic {
            return values()
                .find { arithmetic -> arithmetic.symbols == symbols } ?: throw NoSuchElementException("+, -, *, /만 입력 가능합니다.")
        }

        fun isArithmetic(symbols: String): Boolean = values().any { it.symbols == symbols }
    }
}
