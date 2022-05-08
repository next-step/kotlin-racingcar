package step2

object Calculator {

    fun calculate(input: String): Double {

        val inputList: List<String> = splitInput(input)

        var result: Double = inputList[0].toDouble()

        for (i: Int in 1 until inputList.size step 2) {
            result = computeByOperator(inputList[i], result, inputList[i + 1].toDouble())
        }

        return result
    }

    @Throws(IllegalArgumentException::class)
    fun splitInput(input: String): List<String> {
        val inputList: List<String> = input.split(' ')
        require(inputList.size % 2 == 1) { ErrorMessage.INCORRECT_INPUT }

        return inputList
    }

    fun computeByOperator(operator: String, acc: Double, operand: Double): Double = Operator.of(operator)
        .calculate(acc, operand)
}
