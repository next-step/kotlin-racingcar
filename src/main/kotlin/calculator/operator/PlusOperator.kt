package calculator.operator

object PlusOperator : Operator {
    override fun operate(first: Int, second: Int): Int {
        return first + second
    }
}
