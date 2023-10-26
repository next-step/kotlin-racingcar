package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    private lateinit var calculator: StringCalculator

    @ParameterizedTest
    @DisplayName("덧셈")
    @CsvSource(value = ["1 + 2:3", "5 + 7:12", "9 + -3:6", "1 + 2 + 5 + 7:15"], delimiter = ':')
    fun sum(input: String, expected: Int) {
        // given.

        // when.
        val actual = calculator.execute(input)

        // then.
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("뺄셈")
    @CsvSource(value = ["3 - 1:2", "12 - 7:5", "4 - 16:-12", "-7 - 3:-10", "20 - 10 - 15 - 2:-7"], delimiter = ':')
    fun subtract(input: String, expected: Int) {
        // given.

        // when.
        val actual = calculator.execute(input)

        // then.
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("곱셈")
    @CsvSource(value = ["3 * 5:15", "12 * 0:0", "-1 * 5:-5", "3 * 4 * 5 * 6:360"], delimiter = ':')
    fun multiply(input: String, expected: Int) {
        // given.

        // when.
        val actual = calculator.execute(input)

        // then.
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("나눗셈")
    @CsvSource(value = ["3 / 1:3", "12 / 2:6", "15 / 2 / 3:2"], delimiter = ':')
    fun divide(input: String, expected: Int) {
        // given.

        // when.
        val actual = calculator.execute(input)

        // then.
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("연산자 복합 사용")
    @CsvSource(value = ["2 + 3 * 4 / 2:10", "12 / 2 + 5 * 3:33"], delimiter = ':')
    fun complex(input: String, expected: Int) {
        // given.

        // when.
        val actual = calculator.execute(input)

        // then.
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException이 발생한다")
    @ValueSource(strings = ["", "    ", "\t"])
    fun inputFailedBlank(input: String) {
        // given.

        // when. & then.
        assertThatThrownBy { calculator.execute(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값은 빈 공백 문자일 수 없습니다")
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생한다")
    @ValueSource(strings = ["@", "&", "#"])
    fun inputFailedInvalidOperator(input: String) {
        // given.

        // when. & then.
        assertThatThrownBy { calculator.execute(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효하지 않은 연산 기호가 포함되어 있습니다")
    }

    @BeforeAll
    fun setUp() {
        calculator = StringCalculator()
    }
}
