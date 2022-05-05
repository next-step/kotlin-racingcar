package calculator

class ExpressionFactory(
    private val separationStrategy: SeparationStrategy
) {

    fun create(expressionText: String): Expression {
        val splitTexts = separationStrategy.separate(expressionText)
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

    companion object {
        private const val EVEN_AND_ODD_STANDARD = 2
        private const val NUMBER_POSITION = 0
    }
}
