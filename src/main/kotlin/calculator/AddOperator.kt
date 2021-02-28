package calculator

object AddOperator : Operator {
    override val value = "+"

    fun operate(a: Int, b: Int): Int {
        return a + b
    }
}
