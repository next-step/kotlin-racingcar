package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `두 수의 합`() {
        assertThat(Calculator().calculate("1 + 1")).isEqualTo(2)
    }

    @Test
    fun `두 수의 차`() {
        assertThat(Calculator().calculate("10 - 7")).isEqualTo(3)
    }

    @Test
    fun `두 수의 곱`() {
        assertThat(Calculator().calculate("5 * 3")).isEqualTo(15)
    }

    @Test
    fun `두 수의 나눗셈`() {
        assertThat(Calculator().calculate("4 / 2")).isEqualTo(2)
    }

    @Test
    fun `사칙 연산 모두 포함`() {
        assertThat(Calculator().calculate("1 + 5 * 7 / 2")).isEqualTo(21)
    }

    @Test
    fun `입력 값 널이거나 빈 공백`() {
        assertThatThrownBy {
            Calculator().calculate("")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("Input value is empty")
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        assertThatThrownBy {
            Calculator().calculate("4 / 2 # 3 ")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("Not an arithmetic operator")
    }

    @Test
    fun `첫 번째 값이 숫자가 아닌 문자인 경우`() {
        assertThatThrownBy {
            Calculator().calculate("o / 2 # 3 ")
        }.isInstanceOf(NumberFormatException::class.java).hasMessage("The first value is not a number.")
    }
}
