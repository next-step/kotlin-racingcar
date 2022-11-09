package calculator

class Calculator {
    fun calculate(numbers: List<Double>, operators: List<String>): Double =
        numbers.drop(DEFAULT_OFFSET)
            .foldIndexed(numbers.first()) { index, total, num ->
                operators[index]
                    .let(Operator::of)
                    .calculate(total, num)
            }

    companion object {
        private const val DEFAULT_OFFSET = 1
    }
}
