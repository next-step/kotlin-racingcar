package calculrate

object Calculator {

    fun calculate(expression: String?): Int {
        require(!expression.isNullOrBlank())

        val splits = expression.split(" ")
        val numbers = splits.filterIndexed { index, _ -> index.rem(2) == 0 }.map { it.toInt() }
        val operators = splits.filterIndexed { index, _ -> index.rem(2) == 1 }.map { Operator.of(it) }

        return calculate(numbers, operators.toMutableList())
    }

    private fun calculate(numbers: List<Int>, operators: MutableList<Operator>): Int {
        return numbers.reduce { first, second ->
            val operator = operators.removeFirst()
            operator.operation(first, second)
        }
    }
}
