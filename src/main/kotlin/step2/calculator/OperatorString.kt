package step2.calculator

const val PLUS = "+"
const val MINUS = "-"
const val MULTIPLY = "*"
const val DIVIDE = "/"

enum class OperatorString(val string: String, val operator: Node.Operator) {
    Plus(PLUS, Node.Operator.Plus),
    Minus(MINUS, Node.Operator.Minus),
    Multiply(MULTIPLY, Node.Operator.Multiply),
    Divide(DIVIDE, Node.Operator.Divide)
}
