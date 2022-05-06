package calculator

enum class Expression(val expression: Char, val calculate: (Float, Float) -> Float) {
    Plus('+', { a, b -> a + b }),
    Minus('-', { a, b -> a - b }),
    Multiple('*', { a, b -> a * b }),
    Divide('/', { a, b -> a / b });

    companion object {
        fun from(expression: String): Expression? {
            return Expression.values().firstOrNull {
                it.expression == expression.first()
            }
        }
    }
}
