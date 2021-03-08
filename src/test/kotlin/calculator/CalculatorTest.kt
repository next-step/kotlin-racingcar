package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `null and empty string test`(input: String?) {
        assertThatThrownBy { Calculator(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("input value is null or blank.")
    }

    @Test
    fun `illegal operator test`() {
        assertThatThrownBy { Calculator("3 % 2").getResult() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching("% is illegal value.")
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "+ 2 + 1:start element is not number.",
            "2 + 1 *:end element is not number."
        ],
        delimiter = ':'
    )
    fun `illegal input string test`(input: String, exception: String) {
        assertThatThrownBy { Calculator(input).getResult() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(exception)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "    "])
    fun `blank string test`(input: String?) {
        assertThatThrownBy { Calculator(input) }
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
        assertThat(Calculator(input).getResult()).isEqualTo(calculateResult)
    }
}
