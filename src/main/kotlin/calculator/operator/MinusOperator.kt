package calculator.operator

object MinusOperator : Operator {
    override fun operate(first: Int, second: Int): Int {
        return first - second
    }
}
