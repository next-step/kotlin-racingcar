package calculator

object MultiplyOperator : Operator {
    override val value = "*"

    fun operate(a: Int, b: Int): Int {
        return a * b
    }
}
