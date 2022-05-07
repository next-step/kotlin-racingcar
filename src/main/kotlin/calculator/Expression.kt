package calculator

data class Expression(
    private val numbers: List<Int>,
    private val operators: List<Operator>
) {
    init {
        require(numbers.size == operators.size + 1) {
            "숫자와 연산자의 개수가 적절하지 않습니다."
        }
    }

    fun calculate(): Int {
        return numbers.reduceIndexed { index, first, second ->
            operators[index - 1].calculate(first, second)
        }
    }

    companion object {
        private const val EVEN_AND_ODD_STANDARD = 2
        private const val NUMBER_POSITION = 0

        fun of(expressionText: String, separator: String = " "): Expression {
            val splitTexts = expressionText.split(separator)
            val numbersAndOperators = splitTexts.withIndex()
                .partition { it.index % EVEN_AND_ODD_STANDARD == NUMBER_POSITION }
            val numbers = numbers(numbersAndOperators.first)
            val operators = operators(numbersAndOperators.second)

            return Expression(numbers, operators)
        }

        private fun numbers(texts: List<IndexedValue<String>>): List<Int> {
            return texts.map { toInt(it.value) }
        }

        private fun operators(texts: List<IndexedValue<String>>): List<Operator> {
            return texts.map { it.value.toOperator() }
        }

        private fun toInt(numberText: String) =
            try {
                numberText.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("올바르지 않은 숫자를 입력하였습니다. ($numberText)")
            }

        private fun String.toOperator(): Operator {
            try {
                return Operator.of(this)
            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("올바르지 않은 연산자를 입력하였습니다. ($this)")
            }
        }
    }
}
