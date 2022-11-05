package calculator

class CPU {
    private fun add(i: Int, j: Int): Int = i + j
    private fun subtract(i: Int, j: Int): Int = i - j
    private fun multiply(i: Int, j: Int): Int = i * j
    private fun divide(i: Int, j: Int): Int = i / j

    fun execute(operator: Operator, operand1: Int, operand2: Int): Int {
        return when (operator) {
            Operator.ADD -> {
                add(operand1, operand2)
            }

            Operator.SUBTRACT -> {
                subtract(operand1, operand2)
            }

            Operator.MULTIPLY -> {
                multiply(operand1, operand2)
            }

            Operator.DIVIDE -> {
                divide(operand1, operand2)
            }
        }
    }
}
