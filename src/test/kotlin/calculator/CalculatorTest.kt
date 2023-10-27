package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CalculatorTest {

    @Test
    fun `덧셈을 수행한다`() {
        val calculator = Calculator()

        val actual = calculator.calculate("1 + 1")
        val result = 2

        assertThat(actual).isEqualTo(result)
    }

    @Test
    fun `뺄셈을 수행한다`() {
        val calculator = Calculator()

        val actual = calculator.calculate("2 - 1")
        val result = 1

        assertThat(actual).isEqualTo(result)
    }

    @Test
    fun `곱하기를 수행한다`() {
        val calculator = Calculator()

        val actual = calculator.calculate("1 * 2")
        val result = 2

        assertThat(actual).isEqualTo(result)
    }

    @Test
    fun `나눗셈을 수행한다`() {
        val calculator = Calculator()

        val actual = calculator.calculate("4 / 2")
        val result = 2

        assertThat(actual).isEqualTo(result)
    }

    @Test
    fun `나눗셈을 할 때 나머지는 모두 버린다`() {
        val calculator = Calculator()

        val actual = calculator.calculate("3 / 2")
        val result = 1

        assertThat(actual).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1 + 2 * 3, 9",
            "1 - 2 * 3, -3",
            "1 * 2 * 3, 6",
            "1 / 2 * 3, 0",
        ]
    )
    fun `연산자의 종류와는 상관 없이 무조건 앞의 연산자 부터 계산한다`(expression: String, result: Int) {
        val calculator = Calculator()

        val actual = calculator.calculate(expression)

        assertThat(actual).isEqualTo(result)
    }

    @Test
    fun `식이 비어있으면 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate("")
        }
    }

    @Test
    fun `식이 공백이면 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate(" ")
        }
    }

    @Test
    fun `식이 null 이면 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate(null)
        }
    }

    @Test
    fun `식의 맨 앞이 숫자가 아니면 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate("+ 1")
        }
    }

    @Test
    fun `식의 맨 뒤가 숫자가 아니면 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate("1 +")
        }
    }

    @Test
    fun `숫자가 연속으로 나오면 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate("1 1")
        }
    }

    @Test
    fun `연산자가 연속으로 나오면 에러가 발생한다`() {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate("+ +")
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "a",
            "1a",
            "@",
        ]
    )
    fun `숫자 혹은 연산자가 아니면 에러가 발생한다`(expression: String) {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate(expression)
        }
    }
}
