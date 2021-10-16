package calculator

enum class Operator : Calculable {

    PLUS {
        override fun execute(first: Int, second: Int): Int {
            return first + second
        }
    },
    MINUS {
        override fun execute(first: Int, second: Int): Int {
            return first - second
        }
    },
    MULTIPLY {
        override fun execute(first: Int, second: Int): Int {
            return first * second
        }
    },
    DIVISION {
        override fun execute(first: Int, second: Int): Int {
            return if (second == 0) 0 else first / second
        }
    };

    companion object {

        private const val SYMBOL_NOT_RIGHT: String = "사칙연산 기호가 아닙니다."

        fun operationEnum(input: String): Operator {
            return when (input) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVISION
                else -> throw IllegalArgumentException(SYMBOL_NOT_RIGHT)
            }
        }
    }
}
