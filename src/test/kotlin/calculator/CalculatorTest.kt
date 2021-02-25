package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {
    @Test
    fun add_simple() {
        var input = "2 + 4"

        val result = calculate(input)

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun subtract_simple() {
        var input = "4 - 2"

        val result = calculate(input)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun multiply_simple() {
        var input = "1 / 3"

        var result = calculate(input)

        assertThat(result).isEqualTo(0)
    }
}
