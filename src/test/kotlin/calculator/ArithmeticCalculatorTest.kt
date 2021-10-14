package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ArithmeticCalculatorTest {

    // given
    private val calculator = ArithmeticCalculator()

    @Test
    fun `입력값이 null이거나 빈 공백 문자열이면 InputNullOrEmptyException 예외 발생`() {
        // when
        val executable: (String?) -> Executable = { input ->
            Executable { calculator.calculate(input) }
        }

        // then
        assertThrows(InputNullOrEmptyException::class.java, executable(""))
        assertThrows(InputNullOrEmptyException::class.java, executable(null))
    }

    @Test
    fun `사칙연산 기호가 아니면 NotArithmeticOperatorException 예외 발생`() {
        // when
        val executable = Executable { calculator.calculate("2 + 3 * 4 % 2") }

        // then
        assertThrows(NotArithmeticOperatorException::class.java, executable)
    }

    @Test
    fun `피연산자 자리에 연산자가 들어와 StringToIntCastException 예외 발생`() {
        // when
        val executable = Executable { calculator.calculate("% 2 + 3 * 4") }

        // then
        assertThrows(StringToIntCastException::class.java, executable)
    }

    @Test
    fun `피연산자를 찾을 수 없는 경우 OperandNotFoundException 예외 발생`() {
        // when
        val executable = Executable { calculator.calculate("2 + 3 * 4 / ") }

        // then
        assertThrows(OperandNotFoundException::class.java, executable)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 3 * 4 / 2:10",
            "5 / 5 + 1 - 2 * 3 + 4:4",
            "10 * 200 / 10 + 50 - 25 * 3:675"
        ],
        delimiter = ':'
    )
    fun `사칙연산 테스트`(input: String, actual: String) {
        // when
        val expected = calculator.calculate(input)

        // then
        assertEquals(expected, actual.toInt())
    }

    @Test
    fun `서로 다른 Delimiter에 대한 기능 테스트`() {
        // given
        val calculator1 = ArithmeticCalculator()
        val calculator2 = ArithmeticCalculator("$")

        // when
        val expected1 = 2 * 5
        val expected2 = 2 * 5
        val actual1 = calculator1.calculate("2 * 5")
        val actual2 = calculator2.calculate("2$*$5")

        // then
        assertEquals(expected1, actual1)
        assertEquals(expected2, actual2)
    }
}
