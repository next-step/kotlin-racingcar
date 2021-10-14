package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    private val calculator = Calculator()

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `인자가 빈값일 때 IllegalArgumentException`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate(input)
        }

        assertEquals(CalculatorResources.IS_NOT_OR_BLANK, exception.message)
    }

    @Test
    fun `인자가 null 일 때 IllegalArgumentException`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate(null)
        }

        assertEquals(CalculatorResources.IS_NOT_OR_BLANK, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 , 3", "3 ) 1"])
    fun `사칙연산 기호가 아닌값이 들어갔을 때 IllegalArgumentException`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate(input)
        }

        assertEquals("사칙연산 기호가 아닙니다.", exception.message)
    }
    @ParameterizedTest
    @ValueSource(strings = ["2 + 1"])
    @Test
    fun `인자가 정상일경우 더하기 연산한 결과를 반환`(input: String) {
        val result = calculator.calculate(input)

        assertThat(3).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3 - 5"])
    @Test
    fun `인자가 정상일경우 빼기 연산한 결과를 반환`(input: String) {
        val result = calculator.calculate(input)

        assertThat(-2).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 / 2"])
    @Test
    fun `인자가 정상일경우 나누기 곱하기 결과를 반환`(input: String) {
        val result = calculator.calculate(input)

        assertThat(1).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["8 * 2"])
    @Test
    fun `인자가 정상일경우 곱하기 연산한 결과를 반환`(input: String) {
        val result = calculator.calculate(input)

        assertThat(16).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["8 * 2 - 1 + 3 / 4"])
    @Test
    fun `인자가 정상일경우 종합 연산한 결과를 반환`(input: String) {
        val result = calculator.calculate(input)

        assertThat(4).isEqualTo(result)
    }
    
}
