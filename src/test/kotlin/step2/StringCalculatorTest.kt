package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @NullSource
    @ValueSource(strings = ["", " ", "    "])
    @ParameterizedTest
    fun `문자열 은 null 이거나 비어있을 수 없다`(expression: String?) {
        assertThrows<IllegalArgumentException> { StringCalculator().calculate(expression = expression) }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 3 * 4 / 2 = 10",
            "10 / 10 = 1",
            "3 * 3 * 3 + 2 - 10 = 19"
        ],
        delimiter = '='
    )
    fun `문자열 식을 성공적으로 계산한다`(input: String, output: Long) {
        val calculator = StringCalculator()
        assertThat(calculator.calculate(input)).isEqualTo(output)
    }
}
