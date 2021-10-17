package calculator

enum class Operator {
    PLUS {
        override fun execute(first: Double, second: Double): Double {
            return first + second
        }
    },
    MINUS {
        override fun execute(first: Double, second: Double): Double {
            return first - second
        }
    },
    MULTIPLY {
        override fun execute(first: Double, second: Double): Double {
            return first * second
        }
    },
    DIVISION {
        override fun execute(first: Double, second: Double): Double {
            return first / second
        }
    };

    abstract fun execute(first: Double, second: Double): Double

    companion object {
        fun getOperatorEnum(operator: String): Operator {
            return when (operator) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVISION
                else -> throw IllegalArgumentException(Message.INVALID_OPERATOR)
            }
        }
    }
}
