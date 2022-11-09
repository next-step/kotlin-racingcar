package calculator

import java.math.BigDecimal
import java.util.StringTokenizer

/**
 * 입력 받은 문자열 계산기
 */
class StringCalculator {

    fun calculator(input: String?): BigDecimal {

        require(!input.isNullOrBlank()) { "입력값이 null 혹은 공백일 수 없습니다." }

        val st = StringTokenizer(input)
        var result = parsedInt(st.nextToken())

        while (st.hasMoreTokens()) {
            val symbol = st.nextToken()
            val nextNumber = parsedInt(st.nextToken())
            result = Operator.of(symbol).operate(result, nextNumber)
        }
        return result
    }

    private fun parsedInt(str: String): BigDecimal {
        return str.toBigDecimalOrNull() ?: throw IllegalArgumentException("잘못된 입력 순서입니다.")
    }
}
