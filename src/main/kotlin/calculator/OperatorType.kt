package calculator

import calculator.operation.Addition
import calculator.operation.ArithmeticOperations
import calculator.operation.Division
import calculator.operation.Multiplication
import calculator.operation.Subtraction

enum class OperatorType(val command: String, val operator: ArithmeticOperations) {
    PLUS("+", Addition()),
    MINUS("-", Subtraction()),
    MULTIPLY("*", Multiplication()),
    DIVIDE("/", Division());

    companion object {
        fun commandOfType(command: String): OperatorType {
            return values().first { it.command == command }
        }
    }
}
