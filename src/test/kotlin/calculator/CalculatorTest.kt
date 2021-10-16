package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "'10000', '10000'",
        "'1 + 2', 3",
        "'5 - 7 * 3', '-6'",
        "'5 * 0 + -25.53', '-25.53'",
        "'-2.4 / 1.2 * 3 - 4.5', '-10.5'",
        "'10 * 3 / 4 + 50', '57.5'",
        "'20 - 3 * 5 / 30 + 7.5', '10.333333'"
    )
    fun `계산기 테스트`(input: String, expected: String) {
        val result = Calculator().calculate(input)

        assertThat(result.value).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "      "])
    @NullAndEmptySource
    fun `계산기 null이나 공백 문자열 입력 테스트`(input: String?) {
        Assertions.assertThatThrownBy {
            Calculator().calculate(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1 +",
            "5 - 7 *",
            "5 * 0 +",
            "-2.4 / 1.2 * 3 - 1 +",
            "5 - 7 *",
            "5 * 0 +",
            "-2.4 / 1.2 * 3 -",
        ]
    )
    fun `인자 개수가 잘못 입력된 테스트`(input: String) {
        Assertions.assertThatThrownBy {
            Calculator().calculate(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
