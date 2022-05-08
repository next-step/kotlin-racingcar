package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    lateinit var calculator: Calculator

    @BeforeEach
    fun intCalculator() {
        calculator = Calculator()
    }

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
        assertThat(calculator.calculate(input)).isEqualTo(result.toLong())
    }

    @Test
    fun `나눗셈 소수점 테스트`() {
        val divideResult = calculator.calculate("5 / 2")
        val divideResult2 = calculator.calculate("3 / 2")

        assertThat(divideResult).isEqualTo(2.5)
        assertThat(divideResult2).isEqualTo(3.0 / 2.0)
    }
}
