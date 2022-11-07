package calculator

class CPU {
    private fun add(preOperand: Int, postOperand: Int): Int = preOperand + postOperand
    private fun subtract(preOperand: Int, postOperand: Int): Int = preOperand - postOperand
    private fun multiply(preOperand: Int, postOperand: Int): Int = preOperand * postOperand
    private fun divide(preOperand: Int, postOperand: Int): Int = preOperand / postOperand

    fun execute(operator: Operator, preOperand: Int, postOperand: Int): Int {
        return when (operator) {
            Operator.ADD -> {
                add(preOperand, postOperand)
            }

            Operator.SUBTRACT -> {
                subtract(preOperand, postOperand)
            }

            Operator.MULTIPLY -> {
                multiply(preOperand, postOperand)
            }

            Operator.DIVIDE -> {
                divide(preOperand, postOperand)
            }
        }
    }
}
