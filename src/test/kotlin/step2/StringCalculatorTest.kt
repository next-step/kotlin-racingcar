package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["2 + 3:5", "3 + 5:8", "1 + 3:4"], delimiter = ':')
    fun `덧셈`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 - 3:-1", "3 - 5:-2", "1 - 3:-2"], delimiter = ':')
    fun `뺄셈`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 * 3:6", "3 * 5:15", "1 * 3:3"], delimiter = ':')
    fun `곱셈`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 / 3:0", "3 / 5:0", "1 / 3:0"], delimiter = ':')
    fun `나눗셈`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값이 null일 경우 IllegalArgumentException throw`() {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(null)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 ^ 3", "3 ^ 5", "1 ^ 3"])
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 + 4:9", "3 + 5 + 7:15", "1 + 3 + 5:9"], delimiter = ':')
    fun `덧셈 2개 이상`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 - 3 - 4:-5", "3 - 5 - 7:-9", "1 - 3 - 5:-7"], delimiter = ':')
    fun `뺄셈 2개 이상`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 * 3 * 4:24", "3 * 5 * 7:105", "1 * 3 * 5:15"], delimiter = ':')
    fun `곱셈 2개 이상`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 / 3 / 4:0", "3 / 5 / 7:0", "1 / 3 / 5:0"], delimiter = ':')
    fun `나눗셈 2개 이상`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 - 4:1", "3 - 5 + 7:5", "1 + 3 - 5:-1"], delimiter = ':')
    fun `덧셈, 뺄셈 혼합`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 * 3 / 4:1", "3 / 5 * 7:0", "1 * 3 / 5:0"], delimiter = ':')
    fun `곱셈, 나눗셈 혼합`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2:10", "2 + 3 * 4:20", "3 * 5 - 7:8", "1 + 3 / 5:0"], delimiter = ':')
    fun `덧셈, 뺄셈, 곱셈, 나눗셈 혼합`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a + b", "! + 4", "a + 4", "2 + b", "2 + 3 + b", "2 + 3 + 4 + b", "2 + 3 + 4 + 5 + b"])
    fun `값의 위치에 수자 아닐 때 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(NumberFormatException::class.java)
    }

    @ParameterizedTest
    @CsvSource(value = ["-2 + 3:1", "3 + -5:-2", "1 + -3:-2", "-3 + -3 + 90:84"], delimiter = ':')
    fun `값이 음수 일 때도 정상적으로 계산된다`(input: String, expect: Int) {
        // when
        val actual = ExpressionCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 +", "3 + 5 +", "1 + 3 + 4 *", "1 + 3 + 4 /"])
    fun `마지막 값이 연산자일 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 +", "3", "1 +"])
    fun `길이가 3보다 작을 경우 IllegalArgumentException throw`(input: String) {
        Assertions.assertThatThrownBy {
            // when
            ExpressionCalculator.calculate(input)
        }
            // then
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
