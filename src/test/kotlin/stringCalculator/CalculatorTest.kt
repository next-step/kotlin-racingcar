package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    val calculator = Calculator()

    fun initialize() {
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
    fun getInput() {
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

    @Test
    fun testGetInput() {
    }

    @Test
    fun setInput() {
    }

    @Test
    fun isValidInput() {
    }

    @Test
    fun isNullOrBlank() {
    }

    @Test
    fun containsNonOperator() {
    }

    @Test
    fun startWithNumber() {
    }

    @Test
    fun endWithNumber() {
    }

    @Test
    fun containsCharacter() {
    }
}