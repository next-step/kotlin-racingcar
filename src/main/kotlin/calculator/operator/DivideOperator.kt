package calculator.operator

object DivideOperator : Operator {
    override fun operate(left: Double, right: Double): Double {
        require(right != 0.0) { "0으로 나눌 수 없습니다." }
        return left / right
    }

    override fun canHandle(operator: String): Boolean {
        return OperatorSymbol.isDivide(operator)
    }
}
