package calculator

const val SYMBOL_ADD = "+"
const val SYMBOL_SUBTRACT = "-"
const val SYMBOL_MULTIPLY = "*"
const val SYMBOL_DIVIDE = "/"

enum class Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    companion object {
        fun findOperator(input: String): Operator {
            return when (input) {
                SYMBOL_ADD -> ADD
                SYMBOL_SUBTRACT -> SUBTRACT
                SYMBOL_MULTIPLY -> MULTIPLY
                SYMBOL_DIVIDE -> DIVIDE
                else -> throw IllegalArgumentException("Invalid operator for Operator.findOperator()")
            }
        }

        fun operate(leftNumber: Int, rightNumber: Int, operator: String): Int {
            return when (operator) {
                SYMBOL_ADD -> leftNumber + rightNumber
                SYMBOL_SUBTRACT -> leftNumber - rightNumber
                SYMBOL_MULTIPLY -> leftNumber * rightNumber
                SYMBOL_DIVIDE -> leftNumber / rightNumber
                else -> throw IllegalArgumentException("Invalid operator for Operator.operate()")
            }
        }
    }
}
