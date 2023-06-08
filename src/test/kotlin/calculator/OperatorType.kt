package calculator

enum class OperatorType(
    val operator: String
) {
    PLUS("+") {
        override fun calculate(leftOperand: Int, rightOperand: Int): Int {
            return leftOperand.plus(rightOperand)
        }
    },
    MINUS("-") {
        override fun calculate(leftOperand: Int, rightOperand: Int): Int {
            return leftOperand.minus(rightOperand)
        }
    },
    MULTIPLY("*") {
        override fun calculate(leftOperand: Int, rightOperand: Int): Int {
            return leftOperand.times(rightOperand)
        }
    },
    DIVIDE("/") {
        override fun calculate(leftOperand: Int, rightOperand: Int): Int {
            return leftOperand.div(rightOperand)
        }
    };

    abstract fun calculate(leftOperand: Int, rightOperand: Int): Int

    companion object {
        fun findOperator(operator: String): OperatorType? =
            OperatorType.values().firstOrNull { it.operator == operator }
    }
}
