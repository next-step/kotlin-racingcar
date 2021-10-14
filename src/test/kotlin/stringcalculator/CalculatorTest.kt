package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "1 + 2, 3",
        "1 - 2, -1",
        "1 * 2, 2",
        "1 / 2, 0",
        "1 + 2 * 3, 9",
        "1 + 2 / 3, 1",
        "2 + 3 * 4 / 2, 10",
        "1000 * 1000, 1000000",
    )
    fun `올바르게 계산을 할 수 있다`(input: String, expected: Int) {
        val result = Calculator(InputValidator(), InputConverter()).calculate(input)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "1 2", "1+2", "1 + 2 +", "1 % 2"])
    fun `잘못된 입력을 받으면 IllegalArgumentException 을 일으킨다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Calculator(InputValidator(), InputConverter()).calculate(input)
        }
    }
}
