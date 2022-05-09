package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = ["3,4", "1,4", "4,7"])
    fun minus(a: Long, b: Long) {
        assertThat(Calculator().minus(a, b) == a - b)
    }

    @ParameterizedTest
    @CsvSource(value = ["3,4", "1,4", "4,7"])
    fun plus(a: Long, b: Long) {
        assertThat(Calculator().plus(a, b) == a + b)
    }

    @ParameterizedTest
    @CsvSource(value = ["3,4", "1,4", "4,7"])
    fun multiply(a: Long, b: Long) {
        assertThat(Calculator().multiply(a, b) == a * b)
    }

    @ParameterizedTest
    @CsvSource(value = ["3,4", "1,4", "4,7"])
    fun divide(a: Long, b: Long) {
        assertThat(Calculator().divide(a, b) == a / b)
    }

    @Test
    fun `null input`() {
        assertThatThrownBy {
            Calculator().calculate(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `blank input`() {
        assertThatThrownBy {
            Calculator().calculate(" ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `illegal space`() {
        assertThatThrownBy {
            Calculator().calculate("3+ 2 ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `illegal operand`() {
        assertThatThrownBy {
            Calculator().calculate("3 b 2")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `insufficient param`() {
        assertThatThrownBy {
            Calculator().calculate("2 + ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun calculate() {
        assertThat(Calculator().calculate("3 + 2") == 5L)
        assertThat(Calculator().calculate("2 + 3 * 4 / 2") == 10L)
        assertThat(Calculator().calculate("6 - 2 / 4 * 3") == 4L)
    }
}
