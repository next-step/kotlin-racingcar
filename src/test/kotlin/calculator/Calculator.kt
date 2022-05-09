package calculator

class Calculator() {
    fun calculate(input: String): Int {
        if (input.trim().isEmpty()) {
            throw IllegalArgumentException("잘못된 입력값입니다.")
        }

        val numbers = this.getNumbers(input)
        val symbols = this.getSymbols(input)

        return evaluate(numbers, symbols)
    }

    fun plus(source: Int, other: Int): Int = source.plus(other)

    fun minus(source: Int, other: Int): Int = source.minus(other)

    fun multiply(source: Int, other: Int): Int = source.times(other)

    fun division(source: Int, other: Int): Int = source.div(other)

    private fun evaluate(
        numbers: List<Int>,
        symbols: List<String>
    ) = numbers.reduceIndexed { index, acc, s ->
        when (symbols[index - 1]) {
            "+" -> this.plus(acc, s)
            "-" -> this.minus(acc, s)
            "*" -> this.multiply(acc, s)
            "/" -> this.division(acc, s)
            else -> throw IllegalArgumentException("잘못된 사칙연산 기호입니다.")
        }
    }

    private fun getSymbols(source: String): List<String> =
        source.split(" ")
            .filter {
                it.toIntOrNull() === null
            }

    private fun getNumbers(source: String): List<Int> =
        source.split(" ")
            .filter {
                it.toIntOrNull() !== null
            }
            .map {
                it.toInt()
            }
}
