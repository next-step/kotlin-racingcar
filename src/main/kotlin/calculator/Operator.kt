package calculator

enum class Operator {
    PLUS {
        override fun apply(
            left: Double,
            right: Double,
        ): Double {
            return left + right
        }
    },

    MINUS {
        override fun apply(
            left: Double,
            right: Double,
        ): Double {
            return left - right
        }
    },

    MULTIPLY {
        override fun apply(
            left: Double,
            right: Double,
        ): Double {
            return left * right
        }
    },

    DIVIDE {
        override fun apply(
            left: Double,
            right: Double,
        ): Double {
            require(left != 0.0 && right != 0.0) { "0으로 나눌 수 없습니다." }

            return left / right
        }
    }, ;

    abstract fun apply(
        left: Double,
        right: Double,
    ): Double

    companion object {
        fun from(operator: String): Operator {
            return when (operator) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("올바르지 않은 연산자입니다.")
            }
        }
    }
}
