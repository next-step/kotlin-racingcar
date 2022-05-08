package stringcaculator

enum class Operator(val operator: String) {
    PLUS("+") {
        override fun calculate(a: Int, b: Int): Int {
            return a + b
        }
    },
    MINUS("-") {
        override fun calculate(a: Int, b: Int): Int {
            return a - b
        }
    },
    MULTIPLY("*") {
        override fun calculate(a: Int, b: Int): Int {
            return a * b
        }
    },
    DIVIDE("/") {
        override fun calculate(a: Int, b: Int): Int {
            require(b != 0)
            return a / b
        }
    };

    abstract fun calculate(a: Int, b: Int): Int
}
