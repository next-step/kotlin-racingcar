package caculator

enum class Operator(private val operator: String) {
    PLUS("+") {
        override fun operate(num1: Number, num2: Number): Number = num1 + num2
    },
    MINUS("-") {
        override fun operate(num1: Number, num2: Number): Number = num1 - num2
    },
    TIMES("*") {
        override fun operate(num1: Number, num2: Number): Number = num1 * num2
    },
    DIV("/") {
        override fun operate(num1: Number, num2: Number): Number = num1 / num2
    };

    abstract fun operate(num1: Number, num2: Number): Number

    companion object {
        fun find(operator: String): Operator? {
            return values().firstOrNull {
                it.operator == operator
            }
        }
    }
}
