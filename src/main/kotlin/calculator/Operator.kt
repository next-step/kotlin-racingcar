package calculator

interface Operable {
    fun operate(a: Int, b: Int): Int
}

enum class Operator : Operable {
    PLUS {
        override fun operate(a: Int, b: Int): Int = a + b
    },
    MINUS {
        override fun operate(a: Int, b: Int): Int = a - b
    },
    TIMES {
        override fun operate(a: Int, b: Int): Int = a * b
    },
    DIVIDED_BY {
        override fun operate(a: Int, b: Int): Int = a / b
    };

    companion object {
        fun find(symbol: Char): Operator {
            return when (symbol) {
                '+' -> PLUS
                '-' -> MINUS
                '*' -> TIMES
                '/' -> DIVIDED_BY
                else -> throw IllegalArgumentException()
            }
        }
    }
}
