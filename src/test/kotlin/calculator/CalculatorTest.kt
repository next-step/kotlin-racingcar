package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest() {
    private val calculator = Calculator()

    @ParameterizedTest(name = "add {0} and {1} return {2}")
    @CsvSource(
        "98, 1, 99",
        "30, 10, 40",
        "8, 2, 10",
    )
    fun `add test`(
        number1: Int,
        number2: Int,
        expected: Int,
    ) {
        // given & when
        val actual = calculator.execute("+", number1, number2)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "subtract {0} and {1} return {2}")
    @CsvSource(
        "98, 1, 97",
        "30, 10, 20",
        "8, 2, 6",
    )
    fun `subtract test`(
        number1: Int,
        number2: Int,
        expected: Int,
    ) {
        // given & when
        val actual = calculator.execute("-", number1, number2)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "multiply {0} and {1} return {2}")
    @CsvSource(
        "98, 1, 98",
        "30, 10, 300",
        "8, 2, 16",
    )
    fun `multiply test`(
        number1: Int,
        number2: Int,
        expected: Int,
    ) {
        // given & when
        val actual = calculator.execute("*", number1, number2)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "divide {0} by {1} return {2}")
    @CsvSource(
        "98, 1, 98",
        "30, 10, 3",
        "8, 2, 4",
    )
    fun `divide test`(
        number1: Int,
        number2: Int,
        expected: Int,
    ) {
        // given & when
        val actual = calculator.execute("/", number1, number2)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "b", " ", ""])
    fun `throw IllegalArgumentException when symbol is not included in fundamental arithmetic operations`(input: String) {
        // given & when & then
        assertThrows<IllegalArgumentException> { calculator.execute(input, 1, 1) }
    }
}
