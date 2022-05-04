package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 5 = 7",
            "2 - 5 = -3",
            "5 / 1 = 5",
            "2 + 3 * 4 / 2 = 10"
        ],
        delimiter = '='
    )
    fun `연산 테스트`(input: String, result: String) {
        val calculator = Calculator()

        assertThat(calculator.calculate(input)).isEqualTo(result.toLong())
    }
}
