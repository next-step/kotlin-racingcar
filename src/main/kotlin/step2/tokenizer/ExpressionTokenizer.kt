package step2.tokenizer

import step2.expression.ExpressionToken

/**
 * ### 연산식을 토큰화시키시는 역할을 담당하는 클래스 입니다.
 */
class ExpressionTokenizer {

    companion object {
        private val pattern = """\d+|[+\-*/]""".toRegex()
    }

    fun tokenize(expression: String): List<ExpressionToken> {
        return pattern.findAll(expression)
            .map { ExpressionToken(it.value) }
            .toList()
    }
}
