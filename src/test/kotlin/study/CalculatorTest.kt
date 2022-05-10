package study

import Calculator
import StringCalculator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @Test
    fun `null 입력 테스트`() {
        assertThatThrownBy {
            StringCalculator.calculator(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백 입력 테스트`() {
        assertThatThrownBy {
            StringCalculator.calculator("   ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `sum 테스트`() {
        assertThat(Calculator.sum(1, 2)).isEqualTo(3)
    }

    @Test
    fun `minus 테스트`() {
        assertThat(Calculator.minus(4, 2)).isEqualTo(2)
    }

    @Test
    fun `multiple 테스트`() {
        assertThat(Calculator.multiple(1, 2)).isEqualTo(2)
    }

    @Test
    fun `division 테스트`() {
        assertThat(Calculator.division(1, 2)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 / *", "2 - +", "+ + 9", "1 / 2 * 3 5", "1 / 3 +", "1 a 1", " 1 / 2"])
    fun `비 정상적 연산식 테스트`(input: String) {
        assertThatThrownBy {
            StringCalculator.calculator(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `연산식 테스트`() {
        assertThat(StringCalculator.calculator("2 + 3 * 4 / 2")).isEqualTo(10)
        assertThat(StringCalculator.calculator("1 + 2 - 1 * 10 / 2")).isEqualTo(10)
        assertThat(StringCalculator.calculator("10 / 2 * 8")).isEqualTo(40)
        assertThat(StringCalculator.calculator("10 - 1 / 9 + 1")).isEqualTo(2)
        assertThat(StringCalculator.calculator("100 + 1 / 5 - 1")).isEqualTo(19)
        assertThat(StringCalculator.calculator("99 / 9 + 1 * 2")).isEqualTo(24)
        assertThat(StringCalculator.calculator("0 / 1 + 1 - 1")).isEqualTo(0)
    }
}
