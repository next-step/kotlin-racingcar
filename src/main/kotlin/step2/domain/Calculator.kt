package step2.domain

object Calculator {

    fun calculate(expression: String): Int {
        require(!expression.isNullOrBlank()) { "연산식이 null 또는 공백입니다." }
        val expressionWords = expression.split(" ")
        return expressionWords.subList(1, expressionWords.size)
            .asSequence()
            .chunked(2)
            .map { Pair(Operator.values(it[0]), it[1]) }
            .fold(expressionWords[0].toInt()) { sum, monomial -> monomial.first.calculate(sum, monomial.second) }
    }
}
