package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["2 + 3:5", "3 + 5:8", "1 + 3:4"], delimiter = ':')
    fun `덧셈`(input: String, expect: Int) {
        // when
        val actual = StringCalculator.calculate(input)

        // then
        assertThat(actual).isEqualTo(expect)
    }
}
