package calculator.operator

object PlusOperator : Operator {
    override fun operate(left: Double, right: Double): Double {
        return (left + right)
    }

    override fun canHandle(operator: String): Boolean {
        return OperatorSymbol.isPlus(operator)
    }
}
