package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {
    @Test
    fun add_simple() {
        val input = "2 + 4"

        val result = calculate(input)

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun subtract_simple() {
        val input = "4 - 2"

        val result = calculate(input)

        assertThat(result).isEqualTo(2)
    }

    @Test
    fun multiply_simple() {
        val input = "1 * 3"

        val result = calculate(input)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun divide_simple() {
        val input = "4 / 2"

        val result = calculate(input)

        assertThat(result).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 / ", " + 1", "2   1"])
    fun validate_InputIsNotNullOrNotBlank(input: String) {
        var input = input

        assertThatThrownBy { calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "a", "ㅁ", "~", ">"])
    fun validate_OperatorSymbol(invalidOperator: String) {
        val input = StringBuilder()
            .append("1 ")
            .append(invalidOperator)
            .append(" 2")
            .toString()

        assertThatThrownBy { calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
