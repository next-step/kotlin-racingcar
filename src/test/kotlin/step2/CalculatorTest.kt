package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest(name = "Test {index} == {0}")
    @NullSource
    @ValueSource(strings = ["", " ", "  "])
    fun `null or Blank 입력 테스트`(value: String?) {
        assertThatThrownBy { Calculator.calculate(value) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 null 혹은 공백일 수 없습니다.")
    }

    @Test
    fun `Calculator 올바른 입력 테스트`() {
        assertThat(Calculator.calculate("1 + 4 + 3")).isEqualTo(8)
        assertThat(Calculator.calculate("4 + 6 / 3")).isEqualTo(3)
        assertThat(Calculator.calculate("1 + 4 * 4")).isEqualTo(20)
        assertThat(Calculator.calculate("3 + 21 / 3")).isEqualTo(8)
        assertThat(Calculator.calculate("3 + 21 / 3 * 10")).isEqualTo(80)
    }

    @Test
    fun `Calculator Exception 테스트`() {
        assertThatThrownBy { Calculator.calculate("1 2 3") }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("정수가 올 자리가 아닙니다.")
    }

    @Test
    fun `Calculator 연산자 반복입력 Exception 테스트`() {
        assertThatThrownBy { Calculator.calculate("1 + +") }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("연산자 다음에는 정수가 입력 되어야 합니다.")
    }

    @Test
    fun `Calculator 첫번째 값 잘못 입력 Exception 테스트`() {
        assertThatThrownBy { Calculator.calculate("1+ 2 + 3") }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("첫번째 입력값이 정수가 아니므로 변환할 수 없습니다.")
    }
}
