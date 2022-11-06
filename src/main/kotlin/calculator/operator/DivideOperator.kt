package calculator.operator

object DivideOperator : Operator {
    override fun operate(first: Int, second: Int): Int {
        return first / second
    }
}
