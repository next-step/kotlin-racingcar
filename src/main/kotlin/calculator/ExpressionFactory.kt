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
        return (1 until texts.size step TEXT_INTERVAL).map {
            val symbolText = texts[it]
            symbolText.toOperator()
        }
    }

    // TODO: 어떤 때에 때 코틀린의 메서드를 식으로 표현하는 것이 적절할까요?
    private fun toInt(numberText: String) =
        try {
            numberText.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바르지 않은 숫자를 입력하였습니다. ($numberText)")
        }

    // TODO: 어떤 때에 때 확장 함수를 사용하는 것이 적절할까요?
    private fun String.toOperator(): Operator {
        try {
            return Operator.of(this)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("올바르지 않은 연산자를 입력하였습니다. ($this)")
        }
    }

    companion object{
        const val TEXT_INTERVAL = 2
    }
}
