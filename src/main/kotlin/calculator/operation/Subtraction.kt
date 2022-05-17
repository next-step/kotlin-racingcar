package calculator.operation

object Subtraction : Operator("-") {

    override fun operate(leftOperand: Double, rightOperand: Double) = leftOperand - rightOperand
}
