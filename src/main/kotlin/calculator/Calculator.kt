package calculator

class Calculator(private val input: String?) {
    fun calculate(): Int {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException("입력값이 없습니다.") }
        val strings = input.split(" ")
        val numbers = strings.filterIndexed { index, _ -> index % 2 == 0 }
            .map { Number.of(it) }
        val operators = strings.filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.of(it) }

        return numbers.foldIndexed(0) { index, acc, value ->
            if (index == 0) {
                value.number
            } else {
                when (operators[index - 1]) {
                    Operator.PLUS -> acc + value.number
                    Operator.MINUS -> acc - value.number
                    Operator.MULTIPLY -> acc * value.number
                    Operator.DIVIDE -> acc / value.number
                }
            }
        }
    }
}
