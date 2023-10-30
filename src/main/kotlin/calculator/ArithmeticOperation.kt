package calculator

enum class ArithmeticOperation(val operationString: String) : BinaryOperation {
    Plus("+") {
        override fun run(operand1: Int, operand2: Int) = operand1 + operand2
    },
    Minus("-") {
        override fun run(operand1: Int, operand2: Int) = operand1 - operand2
    },
    Multiply("*") {
        override fun run(operand1: Int, operand2: Int) = operand1 * operand2
    },
    Divide("/") {
        override fun run(operand1: Int, operand2: Int) = operand1 / operand2
    }
}
