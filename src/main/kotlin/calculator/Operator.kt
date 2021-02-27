package calculator

enum class Operator : Word {
    PLUS {
        override val operation: (n1: Number, n2: Number) -> Number
            get() = { n1, n2 -> n1 + n2 }
    },
    MINUS {
        override val operation: (n1: Number, n2: Number) -> Number
            get() = { n1, n2 -> n1 - n2 }
    },
    TIMES {
        override val operation: (n1: Number, n2: Number) -> Number
            get() = { n1, n2 -> n1 * n2 }
    },
    DIVIDE {
        override val operation: (n1: Number, n2: Number) -> Number
            get() = { n1, n2 -> n1 / n2 }
    },
    ;

    abstract val operation: (n1: Number, n2: Number) -> Number

    companion object {
        val operators = arrayOf("+", "-", "*", "/")

        fun of(value: String): Operator {
            return when (value.trim()) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> TIMES
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("the value not Operator")
            }
        }
    }
}
