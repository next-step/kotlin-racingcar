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
        val result = inputList.first().toDouble()

        return inputList.drop(1)
            .windowed(2, 2)
            .fold(result) { acc, (operator, number) ->
                Operator.valueOfString(operator).execute(acc, number.toDouble())
            }
    }
}
