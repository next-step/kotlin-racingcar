package study.calculator

enum class Operator {

    PLUS {

        override fun apply(left: Operand, right: Operand): Int {
            return left.value + right.value
        }
    },
    MINUS {
        override fun apply(left: Operand, right: Operand): Int {
            return left.value - right.value
        }
    },
    MULTIPLY {
        override fun apply(left: Operand, right: Operand): Int {
            return left.value * right.value
        }
    },
    DIVIDE {
        override fun apply(left: Operand, right: Operand): Int {
            if (right.value == 0) {
                throw IllegalArgumentException()
            }
            return left.value / right.value
        }
    };

    companion object {
        fun of(value: String): Operator {
            return when (value) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException()
            }
        }
    }

    abstract fun apply(left: Operand, right: Operand): Int
}
