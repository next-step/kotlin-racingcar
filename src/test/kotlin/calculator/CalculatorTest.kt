package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `성공 - 4개 숫자 연산`() {
        val userInput = UserInput("2 + 3 * 4 / 2")
        val result = CalculatorImpl().calculate(userInput)

        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `성공 - 3개 숫자 연산`() {
        val userInput = UserInput("2 + 3 * 4")
        val result = CalculatorImpl().calculate(userInput)

        assertThat(result).isEqualTo(20)
    }

    @Test
    fun `성공 - 2개 숫자 연산`() {
        val userInput = UserInput("2 + 3")
        val result = CalculatorImpl().calculate(userInput)

        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `실패 - 숫자 아닌 값`() {
        val userInput = UserInput("2 + hello")

        assertThatThrownBy(
            { CalculatorImpl().calculate(userInput) }
        ).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("계산식에 숫자와 사칙연산 기호 이외의 값이 포함되어 있습니다")
    }

    @Test
    fun `실패 - 연산자 생략 값`() {
        val userInput = UserInput("2 3")

        assertThatThrownBy(
            { CalculatorImpl().calculate(userInput) }
        ).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("계산식에 사칙연산 기호가 포함되어 있지 않습니다")
    }
}