package calculator

enum class MathOperator(val operator: Char, val calculate: (Float, Float) -> Float) {
    Plus('+', { a, b -> a + b }),
    Minus('-', { a, b -> a - b }),
    Multiple('*', { a, b -> a * b }),
    Divide('/', { a, b -> a / b });

    companion object {
        fun from(operator: String): MathOperator? {
            return MathOperator.values().firstOrNull {
                it.operator == operator.first()
            }
        }
    }
}
