package calculator

class Calculator() {
    fun calculate(input: String): Int {
        validateIsEmpty(input)

        val numbers = Splitter.getNumbers(input)
        val symbols = Splitter.getSymbols(input)

        return evaluate(numbers, symbols)
    }

    private fun validateIsEmpty(value: String) {
        if (value.trim().isEmpty()) {
            throw IllegalArgumentException("잘못된 입력값입니다.")
        }
    }

    private fun evaluate(
        numbers: List<Int>,
        symbols: List<String>
    ) = numbers.reduceIndexed { index, source, other ->
        Operator.findBy(symbols[index - 1]).evaluate(source, other)
    }
}
