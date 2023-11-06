package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
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
        assertThat(Calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(
        "+ + 2,7",
        "+ + 3 * 4 / 2,10",
        "2 * +,6",
        "2 * + / 2,3",
        "4 + + + + - 4,14"
    )
    fun `숫자가 아닌 값이 들어오면 예외가 발생한다`(input: String) {
        assertThrows<NumberFormatException> { Calculator.calculate(input) }
    }

    @ParameterizedTest
    @CsvSource(
        "5 2 2,7",
        "2 & 3 * 4 / 2,10",
        "2 ^ 3,6",
        "2 # 3 / 2,3",
        "4 % 4 ( 10 - 4,14"
    )
    fun `사칙연산기호가 아닌 값이 들어오면 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> { Calculator.calculate(input) }
    }
}
