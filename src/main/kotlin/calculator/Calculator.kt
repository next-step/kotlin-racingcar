package calculator

object Calculator {
    fun calculate(input: String?): Int {
        require(input.isNullOrBlank().not()) { "입력값이 없습니다." }
        val strings = input!!.split(" ")
        val numbers = strings.filterIndexed { index, _ -> index % 2 == 0 }
            .map { Number(it) }
        val operators = strings.filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.of(it) }

        return numberOperation(numbers, operators)
    }

    private fun numberOperation(numbers: List<Number>, operators: List<Operator>): Int {
        return numbers.foldIndexed(0) { index, acc, value ->
            if (index == 0) {
                value.getNumber()
            } else {
                operators[index - 1].operate(acc, value.getNumber())
            }
        }
    }
}
