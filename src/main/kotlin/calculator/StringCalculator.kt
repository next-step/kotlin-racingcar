package calculator

import java.util.StringTokenizer

/**
 * 입력 받은 문자열 계산기
 */
class StringCalculator {

    fun calculator(input: String?): Int {

        require(!input.isNullOrBlank()) { "입력값이 null 혹은 공백일 수 없습니다." }

        val st = StringTokenizer(input)
        var result = st.nextToken().toInt()

        while (st.hasMoreTokens()) {
            val symbol = st.nextToken()
            val nextNumber = parsedInt(st.nextToken())
            result = Operator.of(symbol).operate(result, nextNumber)
        }
        return result
    }

    private fun parsedInt(str: String): Int {
        try {
            return str.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("잘못된 입력 순서입니다.")
        }
    }
}
