package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import step2.Step2Exception.INVALID_INPUT_EXCEPTION
import step2.Step2Exception.IS_NOT_ARITHMETIC_SYMBOL_EXCEPTION
import step2.Step2Exception.IS_NOT_NULL_OR_BLANK_EXCEPTION

class CalculatorTest {

    @ParameterizedTest(name = "Test {index} == {0}")
    @NullSource
    @ValueSource(strings = ["", " ", "  "])
    fun `null or Blank 입력 테스트`(value: String?) {
        assertThatThrownBy { Calculator.calculate(value) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(IS_NOT_NULL_OR_BLANK_EXCEPTION)
    }

    @ParameterizedTest(name = "Test {index}: value == {0}, result == {1}")
    @CsvSource(value = ["1 + 4 + 3, 8", "4 + 6 / 3, 3", "1 + 4 * 4, 20", "3 + 21 / 3, 8", "3 + 21 / 3 * 10, 80"])
    fun `Calculator 올바른 입력 테스트`(value: String?, result: Int) {
        assertThat(Calculator.calculate(value)).isEqualTo(result)
    }

    @Test
    fun `Calculator Exception 테스트`() {
        assertThatThrownBy { Calculator.calculate("1 2 3") }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(IS_NOT_ARITHMETIC_SYMBOL_EXCEPTION)
    }

    @Test
    fun `Calculator 연산자 반복입력 Exception 테스트`() {
        assertThatThrownBy { Calculator.calculate("1 + +") }.isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    fun `Calculator 첫번째 값 잘못 입력 Exception 테스트`() {
        assertThatThrownBy { Calculator.calculate("1+ 2 + 3") }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(INVALID_INPUT_EXCEPTION)
    }
}
