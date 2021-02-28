package calculator

object DivideOperator : Operator {
    override val value = "/"
    fun operate(a: Int, b: Int): Int {
        return a / b
    }
}
