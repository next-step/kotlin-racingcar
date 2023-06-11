package calculator

object Calculator {

    fun execute(inp: String?): Int {
        val str = Validator.validate(inp)

        val args = str.split(" ")

        val (numbers, operators) = args.withIndex().partition { it.index % 2 == 0 }.let { (numbers, operators) ->
            numbers.map { it.value.toInt() } to operators.map { Operator.of(it.value) }
        }

        return calculate(numbers, operators)
    }

    private fun calculate(nums: List<Int>, operators: List<Operator>): Int {
        var operatorIndex = 0
        return nums.drop(1).fold(nums.first()) { acc, i ->
            val operator = operators[operatorIndex]
            operatorIndex++
            val result = operator.exec(acc, i)
            result
        }
    }
}
