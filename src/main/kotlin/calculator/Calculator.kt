package calculator

object Calculator {
    fun calculate(input: String?): Int {
        require(input.isNullOrBlank().not()) { "입력값이 없습니다." }
        val strings = input!!.split(" ")
        val numbers = strings.filterIndexed { index, _ -> index % 2 == 0 }
            .map { Number.of(it) }
        val operators = strings.filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.of(it) }

        return numbers.foldIndexed(0) { index, acc, value ->
            foldGetValueIndex(index, acc, value, operators)
        }
    }

    private fun foldGetValueIndex(index: Int, acc: Int, value: Number, operators: List<Operator>): Int {
        return if (index == 0) {
            value.number
        } else {
            operationValue(operators[index - 1], acc, value)
        }
    }

    private fun operationValue(operator: Operator, acc: Int, value: Number): Int {
        return when (operator) {
            Operator.PLUS -> acc + value.number
            Operator.MINUS -> acc - value.number
            Operator.MULTIPLY -> acc * value.number
            Operator.DIVIDE -> acc / value.number
        }
    }
}
