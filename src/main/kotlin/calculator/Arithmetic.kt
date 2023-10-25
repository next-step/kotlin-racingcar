package calculator

enum class Arithmetic(val symbols: String, val operation: (Int, Int) -> Int) {
    PLUS("+", Int::plus),
    MINUS("-", Int::minus),
    MULTIPLY("*", Int::times),
    DIVIDE("/", Int::div);

    companion object {
        fun of(symbols: String): Arithmetic {
            return values()
                .find { arithmetic -> arithmetic.symbols == symbols } ?: throw NoSuchElementException()
        }
    }
}
