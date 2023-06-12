package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullSource
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
    fun calculateSuccessTest(input: String, output: Double) {
        val result = calculator.calculate(input)
        assertThat(result).isEqualTo(output)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "2 + 3 * 4 | 2 ",
        "100 ! 5"
    ])
    fun notOperatorTest(input: String) {
        assertThrows<IllegalArgumentException> { calculator.calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = [""," "])
    fun caluateFailTest(input: String?) {
        assertThrows<IllegalArgumentException> { calculator.calculate(input) }
    }

    @ParameterizedTest
    @NullSource
    fun calculateNullTest(input: String?) {
        assertThrows<IllegalArgumentException> { calculator.calculate(input) }
    }

}