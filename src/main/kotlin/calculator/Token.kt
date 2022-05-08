package calculator

sealed class Token {
    data class Number(val value: Int) : Token()

    object Plus : Token()

    object Minus : Token()

    object Asterisk : Token()

    object Slash : Token()

    object EOF : Token()
}
