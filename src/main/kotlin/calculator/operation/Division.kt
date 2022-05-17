package calculator.operation

object Division : Operator("/") {

    override fun operate(leftOperand: Double, rightOperand: Double): Double {
        check(rightOperand != 0.0) { "0 으로 나눌 수 없습니다." }
        return leftOperand / rightOperand
    }
}
