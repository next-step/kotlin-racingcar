package step2.domain

class Calculator {

    companion object {
        private const val DELIMITER = " "
        const val EXPRESSION_NULL_MESSAGE = "연산식이 null 또는 공백입니다."
    }

    fun calculate(expression: String): Int {
        require(!expression.isNullOrBlank()) { EXPRESSION_NULL_MESSAGE }
        val expressionWords = expression.split(DELIMITER)
        return expressionWords.subList(1, expressionWords.size)
            .chunked(2)
            .map { Pair(Operator.values(it[0]), it[1]) }
            .fold(expressionWords[0].toInt()) { sum, monomial -> monomial.first.calculate(sum, monomial.second) }
    }
}
