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

        val parseList: List<Map<String, Any?>> = StringParser.parse(input)
        val firstParse: Map<String, Any?> = parseList.first()
        val withOutFirstParse: List<Map<String, Any?>> = parseList.drop(1)

        val firstExpression: Expression = Expression(
            firstParse["left"].toString().toLong(),
            firstParse["operator"] as Operator,
            firstParse["right"].toString().toLong()
        )
        return withOutFirstParse.fold(firstExpression.calculate()) { expressionResult: Long, parse: Map<String, Any?> ->
            val expression: Expression = Expression(
                expressionResult,
                parse["operator"] as Operator,
                parse["right"].toString().toLong()
            )

            expression.calculate()
        }
    }
}
