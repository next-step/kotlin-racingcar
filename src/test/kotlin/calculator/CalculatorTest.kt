package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2 = 10",
        "2 + 2 = 4",
        "4 - 1 = 3",
        "1 * 2 = 2",
        "4 / 1 = 4",
        delimiter = '='
    )
    internal fun `사칙연산 계산 테스트`(input: String, expected: Int) {
        val result = Calculator.getInput(input)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    internal fun `입력값이 null이거나 빈 공백 문자열일 경우 에러 발생`() {
        assertThrows<IllegalArgumentException> {
            Calculator.getInput(" ")
        }

        assertThrows<IllegalArgumentException> {
            Calculator.getInput(null)
        }
    }

    @Test
    internal fun `사칙연산 기호가 아닌 경우 에러 발생`() {
        assertThrows<IllegalArgumentException> {
            Calculator.getInput("1 ^ 2")
        }
    }

    @Test
    internal fun `0으로 나누려할 경우 에러 발생`() {
        assertThrows<IllegalArgumentException> {
            Calculator.getInput("4 / 0")
        }
    }

    @Test
    internal fun `최소한의 입력값이 입력되지 않았을 경우 에러 발생`() {
        assertThrows<IllegalArgumentException> { Calculator.getInput("1 +") }
        assertThrows<IllegalArgumentException> { Calculator.getInput("1") }
    }
}
