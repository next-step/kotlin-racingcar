@file:Suppress("NonAsciiCharacters")

package calculator

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CalculatorTest {
    @InjectMockKs
    private lateinit var sut: Calculator

    @MockK
    private lateinit var calculatorInputValidator: CalculatorInputValidator

    @MockK
    private lateinit var calculatorInputParser: CalculatorInputParser

    @Test
    fun `calculate - 문자열 입력값이 주어지면 계산된 값을 반환한다`() {
        val input = "2 + 3 * 2 / 2 - 1"
        val parseResult = CalculatorInputParseResult(
            operands = listOf(2.0, 3.0, 2.0, 2.0, 1.0),
            operators = listOf(Operator.PLUS, Operator.MULTIPLY, Operator.DIVIDE, Operator.MINUS),
        )

        every { calculatorInputValidator.validate(any()) } just runs
        every { calculatorInputParser.parse(any()) } returns parseResult

        val result = sut.calculate(input)

        assertThat(result).isEqualTo(4.0)

        verify(exactly = 1) {
            calculatorInputValidator.validate(input)
            calculatorInputParser.parse(input)
        }

        confirmVerified(
            calculatorInputValidator,
            calculatorInputParser,
        )
    }

    @Test
    fun `calculate - 입력값 검증 시 예외가 발생하면 해당 예외를 던진다`() {
        val input = "2 + 3 * 2 / 2"

        every { calculatorInputValidator.validate(any()) } throws RuntimeException("test")

        val result = catchThrowable {
            sut.calculate(input)
        }

        assertThat(result).isInstanceOf(RuntimeException::class.java)
            .hasMessage("test")

        verify(exactly = 1) {
            calculatorInputValidator.validate(input)
        }
        verify(exactly = 0) {
            calculatorInputParser.parse(input)
        }

        confirmVerified(
            calculatorInputValidator,
            calculatorInputParser,
        )
    }

    @Test
    fun `calculate - 입력값 파싱 시 예외가 발생하면 해당 예외를 던진다`() {
        val input = "2 + 3 * 2 / 2"

        every { calculatorInputValidator.validate(any()) } just runs
        every { calculatorInputParser.parse(any()) } throws RuntimeException("test")

        val result = catchThrowable {
            sut.calculate(input)
        }

        assertThat(result).isInstanceOf(RuntimeException::class.java)
            .hasMessage("test")

        verify(exactly = 1) {
            calculatorInputValidator.validate(input)
            calculatorInputParser.parse(input)
        }

        confirmVerified(
            calculatorInputValidator,
            calculatorInputParser,
        )
    }

    @Test
    fun `calculate - 0으로 나눌 경우 ArithmeticException을 던진다`() {
        val input = "2 / 0"
        val parseResult = CalculatorInputParseResult(
            operands = listOf(2.0, 0.0),
            operators = listOf(Operator.DIVIDE),
        )

        every { calculatorInputValidator.validate(any()) } just runs
        every { calculatorInputParser.parse(any()) } returns parseResult

        val result = catchThrowable {
            sut.calculate(input)
        }

        assertThat(result).isInstanceOf(ArithmeticException::class.java)
            .hasMessageContaining("Division by zero.")

        verify(exactly = 1) {
            calculatorInputValidator.validate(input)
            calculatorInputParser.parse(input)
        }

        confirmVerified(
            calculatorInputValidator,
            calculatorInputParser,
        )
    }
}
