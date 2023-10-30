package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "5 + 2,7",
        "2 + 3 * 4 / 2,10",
        "2 * 3,6",
        "2 * 3 / 2,3",
        "4 + 4 + 10 - 4,14"
    )
    fun `계산 테스트`(input: String, result: Int) {
        val calculator = Calculator.from(input)
        assertThat(calculator.calculate()).isEqualTo(result)
    }
}
