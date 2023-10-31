package study.calculator

import calculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("calculateTestData")
    fun `, 올바른 수식을 Calculator의 calculate()에 넣어 호출하면, 올바른 결과값이 나온다`(formula: String, expected: String) {
        // when : 올바른 수식을 calculate()에 넣어 호출한다.
        val actual = Calculator.calculate(formula)

        // then : 올바른 결과값이 나온다.
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `소수점 이하 계산`() {
        // Float로 계산을 한다.
        // 소수점 1자리로 세팅한다.
        // String으로 변환한다.
        // 소수점이 .0일 경우 제거한다.
        val a = 1.000000f

        var strA = a.toString()
        println(strA)
        if (strA[strA.length - 1] == '0') {
            strA = strA.substring(0, strA.length - 2)
        }
        println(strA)
    }

    companion object {
        @JvmStatic
        fun calculateTestData() = listOf(
            arrayOf("2 + 3 * 4 / 2", "10"),
            arrayOf("4 - 1 + 3 * 2", "12"),
            arrayOf("19 * 2 + 18 - 20", "36"),
            arrayOf("3 / 2", "1.5")
        )
    }
}
