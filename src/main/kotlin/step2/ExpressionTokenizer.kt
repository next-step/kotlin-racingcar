package step2

/**
 * ### 연산식을 토큰화시키시는 역할을 담당하는 클래스 입니다.
 */
class ExpressionTokenizer {

    fun tokenize(expression: String): List<String> {
        return expression.split("")
            .filter { it.isNotBlank() }
            .toList()
    }
}
