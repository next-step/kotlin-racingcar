package calculator.operation

object Multiplication : Operator("*") {

    override fun operate(leftOperand: Double, rightOperand: Double) = leftOperand * rightOperand
}
