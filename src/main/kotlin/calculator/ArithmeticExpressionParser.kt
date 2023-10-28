package calculator

import java.util.LinkedList
import java.util.Queue

object ArithmeticExpressionParser {

    private const val DELIMITER = " "

    fun parse(expression: String?): Queue<String> {
        require(!expression.isNullOrBlank()) { "입력값이 null 또는 빈 문자열일 수 없습니다." }

        return LinkedList(expression.split(DELIMITER))
    }
}
