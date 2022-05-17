package calculator.operation

object Addition : Operator("+") {

    override fun operate(leftOperand: Double, rightOperand: Double) = leftOperand + rightOperand
}
