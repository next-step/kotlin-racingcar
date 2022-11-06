package study.step2

enum class Operator(val operator: String) {
    PLUS("+") {
        override fun operate(firstOperand: Int, SecondOperand: Int): Int = firstOperand + SecondOperand
    },
    MINUS("-") {
        override fun operate(firstOperand: Int, SecondOperand: Int): Int = firstOperand - SecondOperand
    },
    MULTIPLY("*") {
        override fun operate(firstOperand: Int, SecondOperand: Int): Int = firstOperand * SecondOperand
    },
    DIVIDE("/") {
        override fun operate(firstOperand: Int, SecondOperand: Int): Int = firstOperand / SecondOperand
    };

    abstract fun operate(firstOperand: Int, SecondOperand: Int): Int
}
