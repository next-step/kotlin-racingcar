package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 4 = 6",
            "1 * 3 * 5 - 2 = 13",
            "5 * 5 - 5 = 20"
        ],
        delimiter = '='
    )
    fun `여러 케이스에 대한 계산 테스트`(input: String, result: String) {
        val calculator = Calculator()
        assertThat(calculator.calculate(input)).isEqualTo(result.toInt())
    }
}
