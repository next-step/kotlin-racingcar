package calculator

class StringCalculator {

    fun calculate(input: String?): Long {
        require(!input.isNullOrBlank()) { "입력값이 없습니다." }

        if (input.toLongOrNull() != null) {
            return input.toLong()
        }

        if (input[0].toString().toLongOrNull() == null) {
            throw IllegalArgumentException("첫번째 입력값이 숫자가 아닙니다.")
        }

        val expressionList: List<Expression> = ExpressionParser.parse(input)
        val firstExpression: Expression = expressionList.first()
        val withOutFirstExpression: List<Expression> = expressionList.drop(1)

        return withOutFirstExpression.fold(firstExpression.calculate()) { expressionResult: Long, expression: Expression ->
            expression.calculate(expressionResult)
        }
    }
}
