package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException
import java.math.BigDecimal

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1 + 2, 3", "1 + 20 + 3, 24", "3 + -2, 1"])
    fun `덧셈`(str: String, expect: BigDecimal) {
        val actual = Calculator().exec(str)

        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["3 - 2, 1", "50 - 40 - 30, -20"])
    fun `뺄셈`(str: String, expect: BigDecimal) {
        val actual = Calculator().exec(str)

        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 * 4, 8", "5 * 4 * 3, 60", "-2 * 23 * 2, -92"])
    fun `곱셈`(str: String, expect: BigDecimal) {
        val actual = Calculator().exec(str)

        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["4 / 2, 2", "3 / 4, 0.75"])
    fun `나눗셈`(str: String, expect: BigDecimal) {
        val actual = Calculator().exec(str)

        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["4 + 2 - 3, 3", "4 - 3 * -2 / 2 + 10, 9"])
    fun `여러 연산자를 사용한 수식`(str: String, expect: BigDecimal) {
        val actual = Calculator().exec(str)

        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "    ", "\n\t"])
    fun `빈문자인 경우 예외 발생`(str: String) {
        assertThrows<IllegalArgumentException> {
            Calculator().exec(str)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a + 2", "2 + 3 -", "3 + * 2", "3 + --2", "2a - 3", "3 % 4"])
    fun `잘못된 수식인 경우 예외 발생`(str: String) {
        assertThrows<IllegalArgumentException> {
            Calculator().exec(str)
        }
    }
}
