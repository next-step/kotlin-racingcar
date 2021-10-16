package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import step2.Step2Exception.CANT_PLACE_NUMBER_EXCEPTION
import step2.Step2Exception.FIRST_VALUE_INVALID_EXCEPTION
import step2.Step2Exception.IS_NOT_NULL_OR_BLANK_EXCEPTION
import step2.Step2Exception.STRING_NEXT_NOT_NUM_EXCEPTION

class CalculatorTest {

    @ParameterizedTest(name = "Test {index} == {0}")
    @NullSource
    @ValueSource(strings = ["", " ", "  "])
    fun `null or Blank 입력 테스트`(value: String?) {
        assertThatThrownBy { Calculator.calculate(value) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(IS_NOT_NULL_OR_BLANK_EXCEPTION)
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
            .hasMessageContaining(CANT_PLACE_NUMBER_EXCEPTION)
    }

    @Test
    fun `Calculator 연산자 반복입력 Exception 테스트`() {
        assertThatThrownBy { Calculator.calculate("1 + +") }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(STRING_NEXT_NOT_NUM_EXCEPTION)
    }

    @Test
    fun `Calculator 첫번째 값 잘못 입력 Exception 테스트`() {
        assertThatThrownBy { Calculator.calculate("1+ 2 + 3") }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(FIRST_VALUE_INVALID_EXCEPTION)
    }
}
