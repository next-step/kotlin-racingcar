package calculator.operator

object MultiplyOperator : Operator {
    override fun operate(left: Double, right: Double): Double {
        return (left * right)
    }

    override fun canHandle(operator: String): Boolean {
        return OperatorSymbol.isMultiply(operator)
    }
}
