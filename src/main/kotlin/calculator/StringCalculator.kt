package calculator

class StringCalculator {
    @Throws(IllegalArgumentException::class)
    fun calculateFromString(input: String): Double {
        val inputList = input.split(" ".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toList()
        require(inputList.size >= 3)
        return calculate(inputList)
    }

    @Throws(IllegalArgumentException::class)
    private fun calculate(inputList: List<String>): Double {
        val list = inputList.takeLast(3)
        val num1 = list[0].toDouble()
        val operator = Operator.valueOfString(list[1])
        val num2 = list[2].toDouble()

        return when (inputList.size) {
            3 -> operator.execute(num1, num2)
            else -> operator.execute(calculate(inputList.dropLast(2)), num2)
        }
    }
}
