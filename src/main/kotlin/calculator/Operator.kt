package calculator

enum class Operator(val operator: Char, val operate: (Int, Int) -> Int) {
    PLUS('+', { left, right -> left + right }),
    MINUS('-', { left, right -> left - right }),
    MULTIPLY('*', { left, right -> left * right }),
    DIVIDE('/', { left, right -> left / right });

    companion object {
        fun from(operator: Char): Operator? = values().find { it.operator == operator }
    }
}
