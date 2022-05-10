package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    private val calculator = Calculator()

    private fun initialize() {
        calculator.input = ""
    }

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
        initialize()
    }

    @Test
    fun `calculate test`() {
        calculator.input = "2 + 3 + 5 / 5"
        val testValue = calculator.calculate()
        Assertions.assertThat(testValue).isEqualTo(2)

        calculator.input = "2 + 3 / 5 - 5"
        val testValue2 = calculator.calculate()
        Assertions.assertThat(testValue2).isEqualTo(-4)

        calculator.input = "3 / 3 + 5 * 5"
        val testValue3 = calculator.calculate()
        Assertions.assertThat(testValue3).isEqualTo(30)
    }
}
