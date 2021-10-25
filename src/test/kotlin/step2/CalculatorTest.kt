package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.assertEquals

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "3 + 5=8",
            "9 + 0 + 1=10"
        ],
        delimiter = '='
    )
    fun `덧셈 테스트`(input: String, actual: String) {
        val expected = Calculator(input).calculate()
        assertEquals(expected, actual.toInt())
    }

    @Test
    fun `곱셈 테스트`() {
        Assertions.assertThat(Calculator("2 * 10").calculate()).isEqualTo(20)
        Assertions.assertThat(Calculator("9 * 9").calculate()).isEqualTo(81)
    }

    @Test
    fun `나눗셈 테스트`() {
        Assertions.assertThat(Calculator("10 / 2").calculate()).isEqualTo(5)
        Assertions.assertThat(Calculator("9 / 1").calculate()).isEqualTo(9)
    }

    @Test
    fun `0으로 나누었을 때 예외 테스트`() {
        Assertions.assertThatThrownBy { Calculator("3 / 0").calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력 값이 null 이거나 빈 공백 문자인 경우`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator("").calculate()
            Calculator(null).calculate()
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator("9 ^ 2 ").calculate()
            Calculator("10 @ 2 ").calculate()
        }
    }

    @Test
    fun `사칙 연산을 모두 포함하는 경우`() {
        Assertions.assertThat(Calculator("2 + 3 * 4 / 2").calculate()).isEqualTo(10)
    }
}
