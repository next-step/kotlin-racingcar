package calculator

import java.lang.IllegalArgumentException

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
    };

    companion object {
        fun getOperation(operationString: String): ArithmeticOperation {
            return ArithmeticOperation.values().firstOrNull {
                it.operationString == operationString
            } ?: throw IllegalArgumentException("invalid operation: `$operationString`")
        }
    }
}
