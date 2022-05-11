package calculator

object Expression {

    private const val FIRST_INDEX = 0
    val STRING_OPERATORS: List<String> = listOf("+", "-", "*", "/")

    fun calculate(operands: MutableList<Int>, operators: MutableList<String>): Int {
        operators.forEach {
            val operator = Operators.getOperator(it)
            val first = operands.removeFirst()
            val second = operands.first()
            val result = operator.calculate(first, second).toInt()
            operands[FIRST_INDEX] = result
        }
        return operands[FIRST_INDEX]
    }
}
