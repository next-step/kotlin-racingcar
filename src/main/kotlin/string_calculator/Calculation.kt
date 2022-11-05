package string_calculator

enum class Calculation(val operator: Char, private val calculation: (Int, Int) -> Int) {
    PLUS('+', { a, b -> a + b }),
    MINUS('-', { a, b -> a - b }),
    MULTIPLY('*', { a, b -> a * b }),
    DIVIDE('/', { a, b -> a / b });

    companion object {
        @JvmStatic
        fun isValid(operator: Char): Boolean {
            return operator in values().map { it.operator }
        }

        @JvmStatic
        fun calculate(a: Int, b: Int, operator: Char): Int =
            values()
                .first() { it.operator == operator }
                .calculation(a, b)
    }
}
