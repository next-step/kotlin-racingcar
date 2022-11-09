package study.step2

enum class Operator(val operator: String) {
    PLUS("+") {
        override fun operate(firstOperand: Int, secondOperand: Int): Int = firstOperand + secondOperand
    },
    MINUS("-") {
        override fun operate(firstOperand: Int, secondOperand: Int): Int = firstOperand - secondOperand
    },
    MULTIPLY("*") {
        override fun operate(firstOperand: Int, secondOperand: Int): Int = firstOperand * secondOperand
    },
    DIVIDE("/") {
        override fun operate(firstOperand: Int, secondOperand: Int): Int = firstOperand / secondOperand
    };

    abstract fun operate(firstOperand: Int, secondOperand: Int): Int

    companion object {
        fun find(operator: String): Operator? {
            return values().find { o -> o.operator == operator }
        }

        fun contains(operator: String): Boolean {
            return values().map { o -> o.operator }.contains(operator)
        }
    }
}
