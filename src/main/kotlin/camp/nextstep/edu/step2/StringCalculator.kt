package camp.nextstep.edu.step2

/**
 * 문자열 계산기
 *
 * 문자열로 이루어진 아주 간단한 사칙연산을 계산합니다.
 * 사칙연산의 순서는 연산자의 종류나 우선순위와 관계없이 왼쪽부터 차례대로 수행합니다.
 *
 * e.g)
 *  StringCalculator().calculate("2 + 3 * 4 / 2") // 10
 */

object StringCalculator {

    private val leftOneRegex: Regex = Regex("""(-?\d+)""")
    private val rightsRegex: Regex = Regex("""([-+/*])\s?(-?\d+)""")

    /**
     * 좌측부터 (숫자 연산자 숫자) 중위 연산 패턴을 찾아 차례대로 계산합니다.
     * @param exp 계산할 수 있는 표현식 문자열
     */
    fun calculate(exp: String?): Double {
        requireNotNull(exp) { "expression should not null." }
        require(exp.isNotBlank()) { "expression should not empty." }

        val leftMatchResult = requireNotNull(leftOneRegex.find(exp)) { "expression should start with number." }
        val rightsMatchResult = requireNotNull(rightsRegex.find(exp)) { "expression should exist at least once of infix expression." }

        var left = leftMatchResult.value.toDouble()
        var rights = if (left < 0) rightsMatchResult.next() else rightsMatchResult

        while (rights != null) {
            val (operator, right) = rights.destructured
            left = doInfix(left, Operator.fromSymbol(operator), right.toDouble())
            rights = rights.next()
        }

        return left
    }

    private fun doInfix(left: Double, operate: Operator, right: Double): Double {
        return operate(left, right)
    }
}
