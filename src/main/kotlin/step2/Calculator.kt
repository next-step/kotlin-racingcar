package step2

import step2.expression.ExpressionItem
import step2.expression.ExpressionToken
import step2.parser.ExpressionParser
import step2.strategy.CalculatorStrategy
import step2.tokenizer.ExpressionTokenizer

/**
 * 전체적인 계산 작업을 오케스트레이션 하는 계산기 클래스 입니다.
 */
class Calculator(
    private val expressionTokenizer: ExpressionTokenizer,
    private val expressionParser: ExpressionParser,
    private val calculatorStrategy: CalculatorStrategy
) {

    fun calculate(expression: String?): String {
        val expressionTokens: List<ExpressionToken> = expressionTokenizer.tokenize(expression!!)
        val expressionItems: List<ExpressionItem> = expressionParser.parse(expressionTokens)
        return calculatorStrategy.apply(expressionItems)
    }
}
