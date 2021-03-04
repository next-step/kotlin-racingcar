package step2_string_calculator.calculator.engine

enum class Operator(val value: String) {
    PLUS("+") {
        override fun run(left: Int, right: Int): Int {
            return left + right
        }
    },
    MINUS("-") {
        override fun run(left: Int, right: Int): Int {
            return left - right
        }
    },
    MULTIPLY("*") {
        override fun run(left: Int, right: Int): Int {
            return left * right
        }
    },
    DIVIDE("/") {
        override fun run(left: Int, right: Int): Int {
            return left / right
        }
    };

    abstract fun run(left: Int, right: Int): Int
}
