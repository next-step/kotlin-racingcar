package step2

import java.util.regex.Pattern

/**
 * ### 연산식을 검증하는 클래스 입니다.
 *
 * <숫자> <연산자> .. <숫자> 표현을 기대하며 공백을 허용합니다.
 */
class ExpressionValidator {

    private val patternThatAllowWhiteSpace = Pattern.compile("(\\s*(\\d)\\s*([+\\-*/])\\s*)+(\\d)\\s*")

    fun validate(expression: String?) {
        require(!expression.isNullOrEmpty()) { "Expression must not be a null or empty" }
        val matcher = patternThatAllowWhiteSpace.matcher(expression)
        require(matcher.matches()) { "invalid input detected" }
    }
}
