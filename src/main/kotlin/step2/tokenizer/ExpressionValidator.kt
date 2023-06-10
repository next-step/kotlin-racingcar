package step2.tokenizer

/**
 * ### 연산식을 검증하는 클래스 입니다.
 *
 * <숫자> <연산자> .. <숫자> 표현을 기대하며 공백을 허용합니다.
 */
object ExpressionValidator {

    private val patternThatAllowWhiteSpace = """(\s*(\d*)\s*([+\-*/])\s*)+(\d*)\s*""".toRegex()

    fun validate(expression: String?) {
        require(!expression.isNullOrEmpty()) { "Expression must not be a null or empty" }
        require(patternThatAllowWhiteSpace.matches(expression)) { "invalid input detected" }
    }
}
