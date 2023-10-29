@file:Suppress("NonAsciiCharacters")

package calculator

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockkObject
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CalculatorTest {
    @BeforeEach
    fun setUp() {
        mockkObject(CalculatorInputGenerator)
    }

    @Test
    fun `calculate - 문자열 입력값이 주어지면 계산된 값을 반환한다`() {
        val input = "2 + 3 * 2 / 2 - 1"
        val calculatorInput = CalculatorInput(
            operands = listOf(2.0, 3.0, 2.0, 2.0, 1.0),
            operators = listOf(Operator.PLUS, Operator.MULTIPLY, Operator.DIVIDE, Operator.MINUS),
        )

        every { CalculatorInputGenerator.generate(any()) } returns calculatorInput

        val result = Calculator.calculate(input)

        assertThat(result).isEqualTo(4.0)

        verify(exactly = 1) {
            CalculatorInputGenerator.generate(input)
        }

        confirmVerified(
            CalculatorInputGenerator,
        )
    }

    @Test
    fun `calculate - CalculatorInput 생성 시 예외가 발생하면 해당 예외를 던진다`() {
        val input = "2 + 3 * 2 / 2"

        every { CalculatorInputGenerator.generate(any()) } throws RuntimeException("test")

        val result = catchThrowable {
            Calculator.calculate(input)
        }

        assertThat(result).isInstanceOf(RuntimeException::class.java)
            .hasMessage("test")

        verify(exactly = 1) {
            CalculatorInputGenerator.generate(input)
        }

        confirmVerified(
            CalculatorInputGenerator,
        )
    }
}
