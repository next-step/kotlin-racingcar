package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
    @ValueSource(
        strings = [
            "2 + 3 * 4 / 2:10",
            "5 / 5 + 1 - 2 * 3 + 4:4",
            "10 * 200 / 10 + 50 - 25 * 3:675"
        ]
    )
    fun `사칙연산 테스트`(input: String) {
        // when
        val actual = input.split(":")[1].toInt()
        val expected = calculator.calculate(input.split(":")[0])

        // then
        assertEquals(expected, actual)
    }
}
