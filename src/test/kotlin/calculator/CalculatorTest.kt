package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource


internal class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3 * 4 / 2 , 10",
        "1 + 2, 3",
        "5 - 2, 3",
        "2 * 3 * 4, 24",
        "100 / 5, 20",
    )
    fun `주어진 사칙연산을 성공적으로 수행하는지`(input: String, output: Double) {
        val result = calculator.calculate(input)
        assertThat(result).isEqualTo(output)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "2 + 3 * 4 | 2 ",
        "100 ! 5"
    ])
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException가 던져지는지`(input: String) {
        assertThrows<IllegalArgumentException> { calculator.calculate(input) }
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "  "])
    fun `Null이나 빈 공백 문자열에 IllegalArgumentException가 던져지는지`(input: String?) {
        assertThrows<IllegalArgumentException> { calculator.calculate(input) }
    }

}