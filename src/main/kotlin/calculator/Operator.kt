package calculator

const val SYMBOL_ADD = "+"
const val SYMBOL_SUBTRACT = "-"
const val SYMBOL_MULTIPLY = "*"
const val SYMBOL_DIVIDE = "/"

enum class Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE
}

fun findOperator(input: String): Operator {
    return when (input) {
        SYMBOL_ADD -> Operator.ADD
        SYMBOL_SUBTRACT -> Operator.SUBTRACT
        SYMBOL_MULTIPLY -> Operator.MULTIPLY
        SYMBOL_DIVIDE -> Operator.DIVIDE
        else -> throw IllegalArgumentException()
    }
}

fun operate(leftNumber: Int, rightNumber: Int, operator: String): Int {
    return when (operator) {
        SYMBOL_ADD -> leftNumber + rightNumber
        SYMBOL_SUBTRACT -> leftNumber - rightNumber
        SYMBOL_MULTIPLY -> leftNumber * rightNumber
        SYMBOL_DIVIDE -> leftNumber / rightNumber
        else -> throw IllegalArgumentException()
    }
}
