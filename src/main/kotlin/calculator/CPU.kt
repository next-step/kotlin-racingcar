package calculator

class CPU {
    fun execute(operator: Operator, preOperand: Int, postOperand: Int): Int {
        return operator.execute(preOperand, postOperand)
    }
}
