package calculator

class ArithmeticCalculator(
    private val delimiter: String = DELIMITER_DEFAULT
) : Calculator(OPERATORS) {

    override fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) {
            throw InputNullOrEmptyException()
        }
        return input
            .trim()
            .split(delimiter)
            .let { calculate(it[0].toIntOrThrow(), it.drop(1)) }
    }

    private tailrec fun calculate(acc: Int, subList: List<String>): Int {
        if (subList.isEmpty()) {
            return acc
        }
        val operator = findOperatorOrThrow(subList[0])
        val operand = subList.getOrNull(1)
            ?.toIntOrThrow()
            ?: throw OperandNotFoundException()

        return calculate(operator.operate(acc, operand), subList.drop(2))
    }

    private fun findOperatorOrThrow(symbol: String): Operator =
        findOperator(Symbol(symbol)) ?: throw NotArithmeticOperatorException(symbol)

    private fun String.toIntOrThrow(): Int = toIntOrNull() ?: throw StringToIntCastException(this)

    companion object {
        private const val DELIMITER_DEFAULT = " "
        private val OPERATORS = listOf(
            ArithmeticOperator.PLUS,
            ArithmeticOperator.SUBTRACT,
            ArithmeticOperator.MULTIPLY,
            ArithmeticOperator.DIVIDE
        )
    }
}
