package calculator

object Calculator {
    fun calculate(input: String): String {
        require(input.isBlank()) { throw IllegalArgumentException(Message.INPUT_EMPTY) }
        val dividedInput = InputParser.splitSpace(input)
        var result = dividedInput[Constant.FIRST_ITEM].toDouble()

        dividedInput.drop(0)
            .forEachIndexed { index, item ->
                if (index % 2 != 0) {
                    val operator = Operator.getOperatorEnum(item)
                    result = operator.execute(result, dividedInput[index + 1].toDouble())
                }
            }

        return result.toString()
    }
}
