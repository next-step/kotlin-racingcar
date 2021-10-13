package calculator

class ArithmeticCalculator : Calculator(OPERATORS) {

    override fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("input must not be null or empty")
        }
        return input
            .trim()
            .split(DELIMITERS)
            .let { calculate(it[0].toIntOrThrow(), it.drop(1)) }
    }

    private tailrec fun calculate(acc: Int, input: List<String>): Int {
        if (input.isEmpty()) {
            return acc
        }
        val operator = findOperatorOrThrow(input[0])
        val operand = input.getOrNull(1)
            ?.toIntOrThrow()
            ?: throw IllegalArgumentException("operand not found")

        return calculate(operator.operate(acc, operand), input.drop(2))
    }

    private fun findOperatorOrThrow(symbol: String): Operator =
        findOperator(Symbol(symbol)) ?: throw IllegalArgumentException("\"$symbol\" is not arithmetic operator")

    private fun String.toIntOrThrow(): Int = requireNotNull(toIntOrNull()) {
        "can't convert from \"$this\" to Int"
    }

    companion object {
        private const val DELIMITERS = " "
        private val OPERATORS = listOf(
            PlusOperator(),
            SubtractOperator(),
            MultiplyOperator(),
            DivideOperator()
        )
    }
}
