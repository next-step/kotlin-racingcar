package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @Test
    fun `illegal operator test`() {
        assertThatThrownBy { calculate("3 % 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("% is not operator.")
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `null and empty string test`(input: String?) {
        assertThatThrownBy { calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("input value is null or blank.")
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "    "])
    fun `blank string test`(input: String?) {
        assertThatThrownBy { calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("input value is null or blank.")
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 3 * 4 / 2:10",
            "2 + 3:5",
            "3 - 2:1",
            "3 * 2:6",
            "6 / 2:3"
        ],
        delimiter = ':'
    )
    fun `simple calculate test`(input: String, calculateResult: Int) {
        assertThat(calculate(input)).isEqualTo(calculateResult)
    }
}
