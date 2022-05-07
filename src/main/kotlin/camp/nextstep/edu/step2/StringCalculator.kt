package camp.nextstep.edu.step2

import java.util.regex.Pattern

/**
 * 문자열 계산기
 *
 * 문자열로 이루어진 아주 간단한 사칙연산을 계산합니다.
 * 사칙연산의 순서는 연산자의 종류나 우선순위와 관계없이 왼쪽부터 차례대로 수행합니다.
 *
 * e.g)
 *  StringCalculator().calculate("2 + 3 * 4 / 2") // 10
 */

class StringCalculator {

    /**
     * 좌측부터 (숫자 연산자 숫자) 중위 연산 패턴을 찾아 차례대로 계산합니다.
     * @param exp 계산할 수 있는 표현식 문자열
     */
    fun calculate(exp: String?): Int {
        requireNotNull(exp) { "expression should not null." }

        if (exp.isBlank()) {
            throw IllegalArgumentException("expression should not empty.")
        }

        val leftMatcher = leftOnePattern.matcher(exp)
        val rightsMatcher = rightsPattern.matcher(exp)

        if (!leftMatcher.find()) {
            throw IllegalArgumentException("expression should start with number.")
        }

        if (!rightsMatcher.find()) {
            throw IllegalArgumentException("expression should exist at least once of infix expression.")
        }

        var left = leftMatcher.group(1).toInt()
        if (left > 0) rightsMatcher.reset()

        while (rightsMatcher.find()) {
            val operator = rightsMatcher.group(1)
            val right = rightsMatcher.group(2).toInt()
            left = doInfix(left, operator, right)
        }

        return left
    }

    private fun doInfix(left: Int, operator: String, right: Int): Int {
        return when (operator) {
            "+" -> (left.plus(right))
            "-" -> (left.minus(right))
            "/" -> (left.div(right))
            "*" -> (left.times(right))
            else -> throw IllegalArgumentException("$operator is invalid operator (use only [+,-,/,*]).")
        }
    }

    companion object {
        private val leftOnePattern: Pattern = Pattern.compile("(-?\\d+)")
        private val rightsPattern: Pattern = Pattern.compile("([-+/*])\\s?(-?\\d+)")
    }
}
