package step2

import step2.domain.Calculator
import java.util.StringTokenizer

fun main() {
    println("계산식을 입력해주세요.")
    val input = readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")
    println(StringCalculator.calculate(input))
}

private const val INPUT_DELIMITER = " "

class StringCalculator(input: String) {
    init {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력 값이 비어있습니다.")
        }
        calculate(input)
    }

    companion object {
        fun calculate(s: String): Int {
            val st = StringTokenizer(s, INPUT_DELIMITER)
            check(st.countTokens() % 2 != 0) { "입력된 원소의 갯수는 홀수여야 합니다." }
            var result = Integer.parseInt(st.nextToken())
            while (st.hasMoreTokens()) {
                val operator = st.nextToken()
                val operand = Integer.parseInt(st.nextToken())
                result = Calculator.calculate(operator, result, operand)
            }
            return result
        }
    }
}
