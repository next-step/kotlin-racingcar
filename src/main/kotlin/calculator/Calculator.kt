package calculator

object Calculator {
    fun calculate(input: String): String {
        require(input.isNotBlank()) { throw IllegalArgumentException(Message.INPUT_EMPTY) }
        val dividedInput = InputParser.splitSpace(input)
        var result = dividedInput[Constant.FIRST_ITEM].toDouble()

        dividedInput.drop(Constant.FIRST_ITEM)
            .forEachIndexed { index, item ->
                // TODO: 매직넘버를 명시적으로 표현할수 있도록 수정 필요
                if (index % 2 != 0) {
                    val operator = Operator.getOperatorEnum(item)
                    result = operator.execute(result, dividedInput[index + 1].toDouble())
                }
            }

        return result.toString()
    }
}
