package calculator

enum class Operator {
    PLUS {
        override val sign: Char = '+'
        override fun invoke(first: Int, second: Int): Int = first + second
    },
    MINUS {
        override val sign: Char = '-'
        override fun invoke(first: Int, second: Int): Int = first - second
    },
    MULTIPLY {
        override val sign: Char = '*'
        override fun invoke(first: Int, second: Int): Int = first * second
    },
    DIVIDE {
        override val sign: Char = '/'
        override fun invoke(first: Int, second: Int): Int = first / second
    }
    ;

    companion object {
        fun valueOf(sign: Char) = values().firstOrNull { it.sign == sign }
    }

    abstract val sign: Char
    abstract fun invoke(first: Int, second: Int): Int
}
