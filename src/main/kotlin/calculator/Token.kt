package calculator

sealed class Token {
    data class Number(val value: Double) : Token()

    object Plus : Token()

    object Minus : Token()

    object Asterisk : Token()

    object Slash : Token()

    object EOF : Token()
}
