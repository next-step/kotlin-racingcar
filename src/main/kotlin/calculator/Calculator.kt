package calculator

object Calculator {

    private const val DELIMITER = " "

    fun execute(str: String?): Int {
        val s = CalculatorValidate.input(str)

        val args = s.split(DELIMITER)

        val nums = args.filterIndexed { index, _ -> index.rem(2) == 0 }.map { CalculatorValidate.number(it) }
        val operators = args.filterIndexed { index, _ -> index.rem(2) == 1 }.map { Operator.of(it) }

        return calculate(nums, operators)
    }

    private fun calculate(nums: List<Int>, operators: List<Operator>): Int {
        val operatorMutableList = operators.toMutableList()
        return nums.reduce { acc, i ->
            val operator = operatorMutableList.removeFirst()
            val result = operator.operation(acc, i)
            result
        }
    }
}
