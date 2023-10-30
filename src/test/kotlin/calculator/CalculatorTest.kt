package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CalculatorTest {

    companion object {
        @JvmStatic
        fun calculatorHappyTestFixture(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("2 + 3", 5),
                Arguments.of("2 + 3 * 4", 20),
                Arguments.of("2 + 3 * 4 / 2", 10),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("calculatorHappyTestFixture")
    fun `성공 - 2, 3, 4개 숫자 연산`(input: String, expected: Int) {
        val userInput = UserInput(input)
        val result = CalculatorImpl().calculate(userInput)
        assertThat(result).isEqualTo(expected)
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
