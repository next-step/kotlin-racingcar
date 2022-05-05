package calculator

class ExpressionFactory(
    private val separationStrategy: SeparationStrategy
) {

    fun create(expressionText: String): Expression {
        val splitTexts = separationStrategy.separate(expressionText)
        val numbers = numbers(splitTexts)
        val operators = operators(splitTexts)

        return Expression(numbers, operators)
    }

    private fun numbers(texts: List<String>): List<Int> {
        return (texts.indices step TEXT_INTERVAL).map {
            val numberText = texts[it]
            toInt(numberText)
        }
    }

    private fun operators(texts: List<String>): List<Operator> {
        return (OPERATOR_START_INDEX until texts.size step TEXT_INTERVAL).map {
            val symbolText = texts[it]
            symbolText.toOperator()
        }
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
        private const val OPERATOR_START_INDEX = 1
        private const val TEXT_INTERVAL = 2
    }
}
