package calculator

class Calculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            throw java.lang.IllegalArgumentException("Expression cannot be null or blank")
        }

        val processor = CalculateProcessor()
        val expressionElements = ExpressionParser.parse(expression)

        return when (val result = processor.performCalculate(expressionElements)) {
            is ExpressionElement.Term -> result.value
            is ExpressionElement.Operator -> throw IllegalArgumentException("Last type must be number")
        }
    }
}
