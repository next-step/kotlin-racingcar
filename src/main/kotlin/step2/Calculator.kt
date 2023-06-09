package step2

/**
 * 전체적인 계산 작업을 오케스트레이션 하는 계산기 클래스 입니다.
 */
class Calculator(
    private val expressionValidator: ExpressionValidator,
    private val expressionTokenizer: ExpressionTokenizer,
    private val expressionParser: ExpressionParser,
    private val calculatorStrategy: CalculatorStrategy
) {

    fun calculate(expression: String?): String {
        expressionValidator.validate(expression)
        val expressionTokens: List<String> = expressionTokenizer.tokenize(expression!!)
        val expressionItems: List<ExpressionItem> = expressionParser.parse(expressionTokens)
        return calculatorStrategy.apply(expressionItems)
    }
}
