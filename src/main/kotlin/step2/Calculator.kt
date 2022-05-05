package step2

object Calculator {

    fun calculate(input: String?): Double {

        val inputList: List<String> = splitInput(input)

        var result: Double = inputList[0].toDouble()

        var i = 1
        while (i < inputList.size) {
            result = computeByOperator(inputList[i], result, inputList[i + 1].toDouble())
            i += 2
        }

        return result
    }

    @Throws(IllegalArgumentException::class)
    fun splitInput(input: String?): List<String> {
        require(!input.isNullOrBlank()) { ErrorMessage.INCORRECT_INPUT }
        val inputList: List<String> = input.split(' ')
        require(inputList.size % 2 == 1) { ErrorMessage.INCORRECT_INPUT }

        return inputList
    }

    fun computeByOperator(operator: String, acc: Double, operand: Double): Double =
        when (Operator.of(operator)) {
            Operator.PLUS -> acc + operand
            Operator.MINUS -> acc - operand
            Operator.MULTIPLY -> acc * operand
            Operator.DIVISION -> {
                require(operand != 0.0) { ErrorMessage.DIVIDE_BY_ZERO }
                acc / operand
            }
        }
}
