package calculator

class StringCalculator {

    fun calculate(input: String?): Long {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException("입력값이 없습니다.") }

        val expressionList: List<Expression> = ExpressionParser().parse(input)
        val firstExpression: Expression = expressionList.first()
        val withOutFirstExpression: List<Expression> = expressionList.drop(1)

        return withOutFirstExpression.fold(firstExpression.calculate()) { expressionResult: Long, expression: Expression ->
            expression.calculate(expressionResult)
        }
    }
}
