package calculator

enum class Operator(val operator: Char, val operate: (Int, Int) -> Int) {
    PLUS('+', { left, right -> left + right }),
    MINUS('-', { left, right -> left - right }),
    MULTIPLY('*', { left, right -> left * right }),
    DIVIDE('/', { left, right ->
        if (right == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        left / right
    });

    companion object {
        fun from(operator: Char): Operator? = values().find { it.operator == operator }
        val OPERATOR_REGEX = "[+\\-*/]".toRegex()
    }
}
