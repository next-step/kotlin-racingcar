package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = SequenceCalculator()
    }

    @Test
    fun `5 - 3 + 2 나누기 2 * 3 = 6 이다`() {
        calculator.parse("5 - 3 + 2 / 2 * 3")
        calculator.calculate()
        val result = calculator.result()
        assertThat(result).isEqualTo(Number.of("6"))
    }
}
