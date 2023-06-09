package step2

/**
 * ### 연산식을 어떻게 연산할지 결정하는 전략 클래스입니다.
 *
 * 해당 클래스는 우선 순위를 고려하지 않은 사칙 연산 전략을 수행합니다.
 */
class CalculatorStrategy {

    fun apply(expressionItems: List<ExpressionItem>): String {
        var operand = expressionItems.first() as Operand
        for (i in 1 until expressionItems.size step 2) {
            val operator = expressionItems[i] as Operator
            operand = operator.operate(operand, expressionItems[i + 1] as Operand)
        }
        return operand.toString()
    }
}
