package calculator.enums

enum class OperatorsEnum {

    PLUS {
        override fun calculate(left: Double, right: Double): Double {
            return left + right
        }
    },
    MINUS {
        override fun calculate(left: Double, right: Double): Double {
            return left - right
        }
    },
    MULTIPLY {
        override fun calculate(left: Double, right: Double): Double {
            return left * right
        }
    },
    DIVIDE {
        override fun calculate(left: Double, right: Double): Double {
            return left / right
        }
    };

    abstract fun calculate(left: Double, right: Double): Double

    companion object {
        private val charToOperator = mapOf(
            '+' to PLUS,
            '-' to MINUS,
            '*' to MULTIPLY,
            '/' to DIVIDE
        )

        fun fromChar(char: Char): OperatorsEnum? {
            return charToOperator[char]
        }
    }
}
