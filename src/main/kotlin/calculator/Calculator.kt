package calculator

class Calculator {
    companion object {
        private const val INPUT_DELIMITER = " "
        private const val NULL_OR_EMPTY_INPUT = "입력값이 존재하지 않습니다."
        private const val WRONG_NUMBER_OF_OPERANDS = "잘못된 피연산자 개수입니다."
    }

    fun calculate(input: String?): Operand {
        require(input != null && input.isNotBlank()) { NULL_OR_EMPTY_INPUT }
        val inputs = input.split(INPUT_DELIMITER)

        if (inputs.size % 2 == 0) {
            throw IllegalArgumentException(WRONG_NUMBER_OF_OPERANDS)
        }

        var result = Operand(inputs[0].toBigDecimal())

        inputs.drop(1)
            .chunked(2)
            .forEach { (operatorSymbol, value) ->
                result = Operator.findOperation(operatorSymbol).perform(result, Operand.from(value))
            }

        return result
    }

}
