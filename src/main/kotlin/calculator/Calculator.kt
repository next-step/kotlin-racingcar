package calculator

object Calculator {

    private const val DELIMITER = " "

    fun execute(str: String?): Int {
        val s = requireStr(str)

        val args = s.split(DELIMITER)

        val nums = args.filterIndexed { index, _ -> index.rem(2) == 0 }.map { it.toCalInt() }
        val operators = args.filterIndexed { index, _ -> index.rem(2) == 1 }.map { Operator.of(it) }

        return calculate(nums, operators)
    }

    private fun requireStr(str: String?): String {
        require(!str.isNullOrEmpty()) {
            "입력값이 null이거나 빈 공백 문자일 경우"
        }
        return str
    }

    fun calculate(nums: List<Int>, operators: List<Operator>): Int {
        val operatorMutableList = operators.toMutableList()
        return nums.reduce { acc, i ->
            val operator = operatorMutableList.removeFirst()
            val result = operator.operation(acc, i)
            // println(" acc $acc i $i resut $result operator $operator")
            result
        }
    }

    private fun String.toCalInt(): Int {
        require("[0-9]".toRegex().matches(this)) {
            "피연자가 숫자가 아닌 경우"
        }
        return this.toInt()
    }
}
