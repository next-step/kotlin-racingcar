package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    private val calculator = Calculator()

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2", "2 - 3 + 4 * 2", "2 / 3 * 4 - 2"])
    fun `숫자와 연산 분류 검증`(expression: String) {
        val classifiedParams = calculator.classifyParams(expression)
        val numbers = classifiedParams.first
        assertThat(numbers[0]).isEqualTo(2)
        assertThat(numbers[1]).isEqualTo(3)
        assertThat(numbers[2]).isEqualTo(4)
        assertThat(numbers[3]).isEqualTo(2)
    }

    @ParameterizedTest
    @CsvSource(
        "20 + 10 - 15 / 5,3",
        "10 - 5 * 6 / 10,3",
        "3 / 3 * 3 - 0,3",
        "10 * 5 - 5 + 15,60",
        "7 + 3 / 2 - 5,0",
        "21 * 2 - 2 / 4,10",
    )
    fun `연산 검증`(expression: String, expected: Long) {
        val classifiedParams = calculator.classifyParams(expression)
        val result = calculator.calculate(classifiedParams)
        assertThat(result).isEqualTo(expected)
    }
}
