package calculator.operator

object MultiplyOperator : Operator {
    override fun operate(first: Int, second: Int): Int {
        return first * second
    }
}
