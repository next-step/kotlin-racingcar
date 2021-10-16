package step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    private val calculator = Calculator()

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `인자가 빈값일 때 IllegalArgumentException`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate(input)
        }

        assertEquals("인자로는 null 또는 빈값이 올 수 없습니다. $input", exception.message)
    }

    @Test
    fun `인자가 null 일 때 IllegalArgumentException`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate(null)
        }

        assertEquals("인자로는 null 또는 빈값이 올 수 없습니다. null", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 , 3", "2 $ 3"])
    fun `사칙연산 기호가 아닌값이 들어갔을 때 IllegalArgumentException`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate(input)
        }

        assertEquals("입력문자에는 숫자 또는 사칙연산 기호만 올 수 있습니다. $input", exception.message)
    }

    @Test
    fun `인자가 정상일경우 연산한 결과를 반환 case 1`() {
        val input = "2 / 2"
        val result = calculator.calculate(input)

        assertEquals(1.0, result)
    }

    @Test
    fun `인자가 정상일경우 연산한 결과를 반환 case 2`() {
        val input = "2 * 3 + 1 - 30 / 300"
        val result = calculator.calculate(input)

        assertEquals(-0.07666666666666666, result)
    }

    @Test
    fun `인자가 정상일경우 연산한 결과를 반환 case 3`() {
        val input = "2 * 3 + 1 * 10"
        val result = calculator.calculate(input)

        assertEquals(70.0, result)
    }

    @Test
    fun `인자가 정상일경우 연산한 결과를 반환 case 4`() {
        val input = "7 - 4 - 3 - 2"
        val result = calculator.calculate(input)

        assertEquals(-2.0, result)
    }
}
