package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "1 + 2, 3",
        "2 + 3 * 4 / 2, 10",
        "2 * 3 + 3 / 9, 1"
    )
    fun `사칙연산을 수행할 수 있다`(input: String?, result: Double) {
        Assertions.assertThat(StringCalculator().execute(input)).isEqualTo(result)
    }
}
