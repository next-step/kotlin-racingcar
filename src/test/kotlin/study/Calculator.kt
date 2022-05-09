package study

import Calculator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class CalculatorTest {

    @Test
    fun `number와 operator를 분리할 수 있다 - 1`() {
        val expression = "1 + 1"

        val (numbers, operators) = Calculator.splitNumbersAndOperators(expression)

        assertThat(numbers[0]).isEqualTo(1)
        assertThat(numbers[1]).isEqualTo(1)
        assertThat(operators[0]).isEqualTo("+")
    }

    @Test
    fun `number와 operator를 분리할 수 있다 - 2`() {
        val expression = "1 + 2 - 3 * 4 / 5"

        val (numbers, operators) = Calculator.splitNumbersAndOperators(expression)

        assertThat(numbers[0]).isEqualTo(1)
        assertThat(numbers[1]).isEqualTo(2)
        assertThat(numbers[2]).isEqualTo(3)
        assertThat(numbers[3]).isEqualTo(4)
        assertThat(numbers[4]).isEqualTo(5)
        assertThat(operators[0]).isEqualTo("+")
        assertThat(operators[1]).isEqualTo("-")
        assertThat(operators[2]).isEqualTo("*")
        assertThat(operators[3]).isEqualTo("/")
    }

    @Test
    fun `덧셈을 할 수 있다 - 1`() {
        val expression = "1 + 1"

        val result = Calculator.calculate(expression)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `덧셈을 할 수 있다 - 2`() {
        val expression = "2 + 2"

        val result = Calculator.calculate(expression)

        assertThat(result).isEqualTo(4)
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", "  "])
    fun `올바르지 않은 표현식은 exception이 발생한다`(input: String?) {
        assertThatThrownBy {
            Calculator.calculate(input)
        }.isExactlyInstanceOf(java.lang.IllegalArgumentException::class.java)
            .hasMessage("잘못된 계산식 입니다")
    }
}