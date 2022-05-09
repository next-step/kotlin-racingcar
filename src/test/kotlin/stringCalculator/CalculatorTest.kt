package stringCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    lateinit var calculator : Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getInput() {
    }

    @Test
    fun `calculate test`() {
        val testValue = calculator.calculate("2 + 3 + 5 / 5")
        Assertions.assertThat(testValue).isEqualTo(2)

        val testValue2 = calculator.calculate("2 + 3 / 5 - 5")
        Assertions.assertThat(testValue2).isEqualTo(-4)

        val testValue3 = calculator.calculate("3 / 3 + 5 * 5")
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